package com.gmail.michzuerch.locateipaddress.ui.views.errors;

import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.config.Pages;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.*;

import javax.servlet.http.HttpServletResponse;

@ParentLayout(MainView.class)
@PageTitle(Pages.TITLE_NOT_FOUND)
@JsModule("./styles/shared-styles.js")
public class CustomRouteNotFoundError extends RouteNotFoundError {

    private static final long serialVersionUID = 1L;

    public CustomRouteNotFoundError() {
        RouterLink link = Component.from(
                ElementFactory.createRouterLink("", "Go to the front page."),
                RouterLink.class);
        getElement().appendChild(new Text("Oops you hit a 404. ").getElement(), link.getElement());
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        return HttpServletResponse.SC_NOT_FOUND;
    }
}
