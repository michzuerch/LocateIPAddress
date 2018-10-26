package com.gmail.michzuerch.locateipaddress.frontend.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("paper-toggle-button")
@HtmlImport("bower_components/paper-toggle-button/paper-toggle-button.html")
public class PaperToggleButton extends Component {
    public PaperToggleButton() {
    }

    @Synchronize(value = "checked-changed")
    public boolean isChecked() {
        return getElement().getProperty("checked", false);
    }

    public void setChecked(boolean checked) {
        getElement().setProperty("checked", checked);
    }

    public Registration addCheckedChangeListener(ComponentEventListener<CheckedChangeEvent> listener) {
        return this.addListener(CheckedChangeEvent.class, listener);
    }

    @DomEvent("checked-changed")
    public static class CheckedChangeEvent extends ComponentEvent<PaperToggleButton> {

        /**
         * Creates a new event using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source     the source component
         * @param fromClient <code>true</code> if the event originated from the client
         */
        public CheckedChangeEvent(PaperToggleButton source, boolean fromClient) {
            super(source, fromClient);
        }


    }

}
