package com.gmail.michzuerch.locateipaddress.ui.views.dashboard;

import com.gmail.michzuerch.locateipaddress.ui.views.storefront.beans.OrdersCountData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("dashboard-counter-label")
@JsModule("./src/views/dashboard/dashboard-counter-label.js")
public class DashboardCounterLabel extends PolymerTemplate<TemplateModel> {

    private static final long serialVersionUID = 1L;

    @Id("title")
    private H4 title;

    @Id("subtitle")
    private Div subtitle;

    @Id("count")
    private Span count;

    public void setOrdersCountData(OrdersCountData data) {
        title.setText(data.getTitle());
        subtitle.setText(data.getSubtitle());
        count.setText(String.valueOf(data.getCount()));
    }
}
