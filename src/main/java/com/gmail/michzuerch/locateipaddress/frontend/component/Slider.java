package com.gmail.michzuerch.locateipaddress.frontend.component;

import com.vaadin.flow.component.html.Input;

public class Slider extends Input {
    private static final long serialVersionUID = -6486529158347923372L;

    public Slider(int min, int max) {
        setType("range");
        getElement().setProperty("min", min);
        getElement().setProperty("max", max);
    }

    public Integer getOnValue() {
        return Integer.valueOf(super.getValue());
    }

    public Slider setOnValue(Integer value) {
        super.setValue(String.valueOf(value));
        return this;
    }
}