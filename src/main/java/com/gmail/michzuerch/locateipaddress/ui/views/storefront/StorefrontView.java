package com.gmail.michzuerch.locateipaddress.ui.views.storefront;

import com.gmail.michzuerch.locateipaddress.app.HasLogger;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.Order;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.util.EntityUtil;
import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.components.SearchBar;
import com.gmail.michzuerch.locateipaddress.ui.config.Pages;
import com.gmail.michzuerch.locateipaddress.ui.views.EntityView;
import com.gmail.michzuerch.locateipaddress.ui.views.orderedit.OrderDetails;
import com.gmail.michzuerch.locateipaddress.ui.views.orderedit.OrderEditor;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.*;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@Tag("storefront-view")
@JsModule("./src/views/storefront/storefront-view.js")
@Route(value = Pages.PAGE_STOREFRONT, layout = MainView.class)
@RouteAlias(value = Pages.PAGE_STOREFRONT_EDIT, layout = MainView.class)
@RouteAlias(value = Pages.PAGE_ROOT, layout = MainView.class)
@PageTitle(Pages.TITLE_STOREFRONT)
public class StorefrontView extends PolymerTemplate<TemplateModel>
		implements HasLogger, HasUrlParameter<Long>, EntityView<Order> {

	private static final long serialVersionUID = 1L;
	private final OrderEditor orderEditor;
	private final OrderDetails orderDetails = new OrderDetails();
	private final OrderPresenter presenter;
	@Id("search")
	private SearchBar searchBar;
	@Id("grid")
	private Grid<Order> grid;
	@Id("dialog")
	private Dialog dialog;
	private ConfirmDialog confirmation;

	@Autowired
	public StorefrontView(OrderPresenter presenter, OrderEditor orderEditor) {
		this.presenter = presenter;
		this.orderEditor = orderEditor;

		searchBar.setActionText("New order");
		searchBar.setCheckboxText("Show past orders");
		searchBar.setPlaceHolder("Search");

		grid.setSelectionMode(Grid.SelectionMode.NONE);

		grid.addColumn(OrderCard.getTemplate()
				.withProperty("orderCard", OrderCard::create)
				.withProperty("header", order -> presenter.getHeaderByOrderId(order.getId()))
				.withEventHandler("cardClick",
						order -> UI.getCurrent().navigate(Pages.PAGE_STOREFRONT + "/" + order.getId())));

		getSearchBar().addFilterChangeListener(
				e -> presenter.filterChanged(getSearchBar().getFilter(), getSearchBar().isCheckboxChecked()));
		getSearchBar().addActionClickListener(e -> presenter.createNewOrder());

		presenter.init(this);

		dialog.addDialogCloseActionListener(e -> presenter.cancel());
	}

	@Override
	public ConfirmDialog getConfirmDialog() {
		return confirmation;
	}

	@Override
	public void setConfirmDialog(ConfirmDialog confirmDialog) {
		this.confirmation = confirmDialog;
	}

	void setOpened(boolean opened) {
		dialog.setOpened(opened);
	}

	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter Long orderId) {
		boolean editView = event.getLocation().getPath().contains(Pages.PAGE_STOREFRONT_EDIT);
		if (orderId != null) {
			presenter.onNavigation(orderId, editView);
		} else if (dialog.isOpened()) {
			presenter.closeSilently();
		}
	}

	void navigateToMainView() {
		getUI().ifPresent(ui -> ui.navigate(Pages.PAGE_STOREFRONT));
	}

	@Override
	public boolean isDirty() {
		return orderEditor.hasChanges() || orderDetails.isDirty();
	}

	@Override
	public void write(Order entity) throws ValidationException {
		orderEditor.write(entity);
	}

	public Stream<HasValue<?, ?>> validate() {
		return orderEditor.validate();
	}

	SearchBar getSearchBar() {
		return searchBar;
	}

	OrderEditor getOpenedOrderEditor() {
		return orderEditor;
	}

	OrderDetails getOpenedOrderDetails() {
		return orderDetails;
	}

	Grid<Order> getGrid() {
		return grid;
	}

	@Override
	public void clear() {
		orderDetails.setDirty(false);
		orderEditor.clear();
	}

	void setDialogElementsVisibility(boolean editing) {
		dialog.add(editing ? orderEditor : orderDetails);
		orderEditor.setVisible(editing);
		orderDetails.setVisible(!editing);
	}

	@Override
	public String getEntityName() {
		return EntityUtil.getName(Order.class);
	}
}
