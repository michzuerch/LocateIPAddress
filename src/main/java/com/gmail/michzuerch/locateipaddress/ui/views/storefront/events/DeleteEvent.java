package com.gmail.michzuerch.locateipaddress.ui.views.storefront.events;

import com.gmail.michzuerch.locateipaddress.ui.views.orderedit.OrderItemEditor;
import com.vaadin.flow.component.ComponentEvent;

public class DeleteEvent extends ComponentEvent<OrderItemEditor> {
	private static final long serialVersionUID = 1L;

	public DeleteEvent(OrderItemEditor component) {
		super(component, false);
	}
}