package com.gmail.michzuerch.locateipaddress.ui.views.storefront.events;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Product;
import com.gmail.michzuerch.locateipaddress.ui.views.orderedit.OrderItemEditor;
import com.vaadin.flow.component.ComponentEvent;

public class ProductChangeEvent extends ComponentEvent<OrderItemEditor> {

    private static final long serialVersionUID = 1L;
    private final Product product;

    public ProductChangeEvent(OrderItemEditor component, Product product) {
        super(component, false);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

}