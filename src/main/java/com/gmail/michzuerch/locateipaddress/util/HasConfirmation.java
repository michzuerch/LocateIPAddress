package com.gmail.michzuerch.locateipaddress.util;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;

public interface HasConfirmation {

    ConfirmDialog getConfirmDialog();

    void setConfirmDialog(ConfirmDialog confirmDialog);
}
