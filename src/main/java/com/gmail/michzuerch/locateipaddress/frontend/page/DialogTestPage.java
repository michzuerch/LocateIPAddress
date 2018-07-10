package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route(value = "DialogTest", layout = MainLayout.class)
public class DialogTestPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(DialogTestPage.class);

    private Dialog dialog = new Dialog();

    public DialogTestPage() {
        dialog.add(new Label("Label"));
        dialog.setCloseOnEsc(true);
        dialog.setCloseOnOutsideClick(false);
        dialog.open();
    }
}
