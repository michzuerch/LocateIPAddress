package com.gmail.michzuerch.locateipaddress.ui.events;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;

public class DeleteEvent extends ComponentEvent<Component> {

    private static final long serialVersionUID = 1L;

    public DeleteEvent(Component source, boolean fromClient) {
        super(source, fromClient);
    }

}