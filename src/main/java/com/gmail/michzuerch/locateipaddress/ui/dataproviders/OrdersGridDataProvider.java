package com.gmail.michzuerch.locateipaddress.ui.dataproviders;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Order;
import com.gmail.michzuerch.locateipaddress.backend.service.OrderService;
import com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.QuerySortOrderBuilder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A pageable order data provider.
 */
@SpringComponent
@UIScope
public class OrdersGridDataProvider extends FilterablePageableDataProvider<Order, OrdersGridDataProvider.OrderFilter> {

	private static final long serialVersionUID = 1L;
	private final OrderService orderService;
	private List<QuerySortOrder> defaultSortOrders;
	private Consumer<Page<Order>> pageObserver;

	@Autowired
	public OrdersGridDataProvider(OrderService orderService) {
		this.orderService = orderService;
		setSortOrders(I18nConst.DEFAULT_SORT_DIRECTION, I18nConst.ORDER_SORT_FIELDS);
	}

	private void setSortOrders(Sort.Direction direction, String[] properties) {
		QuerySortOrderBuilder builder = new QuerySortOrderBuilder();
		for (String property : properties) {
			if (direction.isAscending()) {
				builder.thenAsc(property);
			} else {
				builder.thenDesc(property);
			}
		}
		defaultSortOrders = builder.build();
	}

	@Override
	protected Page<Order> fetchFromBackEnd(Query<Order, OrderFilter> query, Pageable pageable) {
		OrderFilter filter = query.getFilter().orElse(OrderFilter.getEmptyFilter());
		Page<Order> page = orderService.findAnyMatchingAfterDueDate(Optional.ofNullable(filter.getFilter()),
				getFilterDate(filter.isShowPrevious()), pageable);
		if (pageObserver != null) {
			pageObserver.accept(page);
		}
		return page;
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		return defaultSortOrders;
	}

	@Override
	protected int sizeInBackEnd(Query<Order, OrderFilter> query) {
		OrderFilter filter = query.getFilter().orElse(OrderFilter.getEmptyFilter());
		return (int) orderService
				.countAnyMatchingAfterDueDate(Optional.ofNullable(filter.getFilter()), getFilterDate(filter.isShowPrevious()));
	}

	private Optional<LocalDate> getFilterDate(boolean showPrevious) {
		if (showPrevious) {
			return Optional.empty();
		}

		return Optional.of(LocalDate.now().minusDays(1));
	}

	public void setPageObserver(Consumer<Page<Order>> pageObserver) {
		this.pageObserver = pageObserver;
	}

	@Override
	public Object getId(Order item) {
		return item.getId();
	}

	public static class OrderFilter implements Serializable {
		private static final long serialVersionUID = 1L;
		private String filter;
		private boolean showPrevious;

		public OrderFilter(String filter, boolean showPrevious) {
			this.filter = filter;
			this.showPrevious = showPrevious;
		}

		public static OrderFilter getEmptyFilter() {
			return new OrderFilter("", false);
		}

		public String getFilter() {
			return filter;
		}

		public boolean isShowPrevious() {
			return showPrevious;
		}
	}
}
