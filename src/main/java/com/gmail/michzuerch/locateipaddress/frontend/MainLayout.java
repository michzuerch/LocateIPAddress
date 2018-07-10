/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.gmail.michzuerch.locateipaddress.frontend;

import com.flowingcode.addons.applayout.AppLayout;
import com.flowingcode.addons.applayout.PaperCard;
import com.flowingcode.addons.applayout.menu.MenuItem;
import com.gmail.michzuerch.locateipaddress.Greeter;
import com.gmail.michzuerch.locateipaddress.frontend.block.BlockView;
import com.gmail.michzuerch.locateipaddress.frontend.page.DatabaseTestPage;
import com.gmail.michzuerch.locateipaddress.frontend.page.LocationPage;
import com.gmail.michzuerch.locateipaddress.frontend.page.PushTestPage;
import com.gmail.michzuerch.locateipaddress.frontend.page.UploadPage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.shared.communication.PushMode;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@PageTitle("LocateIPAddress 0.1")
@Push(PushMode.AUTOMATIC)
@Theme(Lumo.class)
@Viewport("width=device-width")
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
public class MainLayout extends VerticalLayout implements RouterLayout {
    private VerticalLayout container = new VerticalLayout();

    public MainLayout() {
        container.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        container.setSizeFull();

        this.setPadding(false);
        this.setSpacing(false);
        this.setMargin(false);

        AppLayout app =new AppLayout("LocateIPAddress 1.0");
        app.setMenuItems(
                new MenuItem("Location", ()->showContent("location")),
                new MenuItem("Block", ()-> getUI().get().navigate("block")),
                new MenuItem("Database Test", () -> getUI().get().navigate("DatabaseTest")),
                new MenuItem("Push Test", () -> getUI().get().navigate("PushTest"))
        );
        app.setToolbarIconButtons(new MenuItem("Delete", "delete", ()-> Notification.show("Delete action")),
                new MenuItem("Search", "search", ()->Notification.show("Search action")),
                new MenuItem("Close", "close", ()->Notification.show("Close action"))
        );

        this.add(app,container);
    }

    private void showContent(String content) {
        container.removeAll();
        H3 label = new H3();
        label.setSizeFull();
        label.setText(content);
        PaperCard pc = new PaperCard(label,new MenuItem("Delete", ()->Notification.show("Delete action from card")),
                new MenuItem("Delete", "delete", ()->Notification.show("Delete action from card")));
        pc.setWidth("100%");
        container.add(pc);
    }
}
