package com.gmail.michzuerch.locateipaddress.ui.views.storefront.events;

import com.gmail.michzuerch.locateipaddress.ui.views.orderedit.OrderItemsEditor;
import com.vaadin.flow.component.ComponentEvent;

public class ValueChangeEvent extends ComponentEvent<OrderItemsEditor> {

	private static final long serialVersionUID = 1L;

	public ValueChangeEvent(OrderItemsEditor component) {
		super(component, false);
	}
}