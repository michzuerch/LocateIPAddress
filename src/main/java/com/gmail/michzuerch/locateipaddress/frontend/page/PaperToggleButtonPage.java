package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.frontend.component.PaperToggleButton;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "PaperToggleButton", layout = MainLayout.class)
public class PaperToggleButtonPage extends VerticalLayout {
    private static final long serialVersionUID = 1337339618913376736L;

    public PaperToggleButtonPage() {
        PaperToggleButton paperToggleButton = new PaperToggleButton();
        paperToggleButton.setChecked(false);
        paperToggleButton.addCheckedChangeListener(event -> {
            Notification.show(event.getSource().toString(), 7000, Notification.Position.BOTTOM_END);
        });
        add(paperToggleButton);
    }
}