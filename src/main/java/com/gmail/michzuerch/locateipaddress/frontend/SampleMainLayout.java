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

import com.gmail.michzuerch.locateipaddress.frontend.page.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.communication.PushMode;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import de.kaesdingeling.hybridmenu.HybridMenu;
import de.kaesdingeling.hybridmenu.components.*;
import de.kaesdingeling.hybridmenu.data.MenuConfig;
import de.kaesdingeling.hybridmenu.design.DesignItem;

@PageTitle("LocateIPAddress 1.0.0-SNAPSHOT")
@Push(PushMode.AUTOMATIC)
@Theme(Lumo.class)
@Viewport("width=device-width")
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
public class SampleMainLayout extends HybridMenu {
    @Override
    public boolean init(VaadinSession vaadinSession, UI ui) {
        withConfig(MenuConfig.get().withDesignItem(DesignItem.getWhiteDesign()));

        TopMenu topMenu = getTopMenu();

        topMenu.add(HMTextField.get(VaadinIcon.SEARCH, "Search ..."));

        topMenu.add(HMButton.get()
                .withIcon(VaadinIcon.HOME)
                .withDescription("Home")
                .withNavigateTo(HomePage.class));

        getNotificationCenter()
                .setNotiButton(topMenu.add(HMButton.get()
                        .withDescription("Notifications")));

        LeftMenu leftMenu = getLeftMenu();

        Image logo = new Image("./frontend/button.svg", "Logo");


        leftMenu.add(HMLabel.get()
                .withCaption("<b>LocateIPAddress</b> Version 1.0.0")
                .withIcon(logo));

        getBreadCrumbs().setRoot(leftMenu.add(HMButton.get()
                .withCaption("Home")
                .withIcon(VaadinIcon.HOME)
                .withNavigateTo(HomePage.class)));

        leftMenu.add(HMButton.get()
                .withCaption("Notification Builder")
                .withIcon(VaadinIcon.BELL)
                .withNavigateTo(NotificationBuilderPage.class));

        leftMenu.add(HMButton.get().withIcon(VaadinIcon.PALETE).withCaption("Block").withNavigateTo(BlockPage.class));
        leftMenu.add(HMButton.get().withIcon(VaadinIcon.TAXI).withCaption("Location").withNavigateTo(LocationPage.class));
        leftMenu.add(HMButton.get().withIcon(VaadinIcon.VIMEO).withCaption("Database Test").withNavigateTo(DatabaseTestPage.class));
        leftMenu.add(HMButton.get().withIcon(VaadinIcon.OFFICE).withCaption("Dialog Test").withNavigateTo(DialogTestPage.class));
        leftMenu.add(HMButton.get().withIcon(VaadinIcon.CLOCK).withCaption("Push Test").withNavigateTo(PushTestPage.class));
        leftMenu.add(HMButton.get().withIcon(VaadinIcon.UMBRELLA).withCaption("Upload").withNavigateTo(UploadPage.class));

		/*
		leftMenu.add(HMButton.get()
				.withCaption("Theme Builder")
				.withIcon(FontAwesome.WRENCH)
				.withNavigateTo(ThemeBuilderPage.class));
		*/

        HMSubMenu memberList = leftMenu.add(HMSubMenu.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS));

        memberList.add(HMButton.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS)
                .withNavigateTo(BlockPage.class));

        memberList.add(HMButton.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(BlockPage.class));

        memberList.add(HMButton.get()
                .withCaption("Group")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(BlockPage.class));

        HMSubMenu memberListTwo = memberList.add(HMSubMenu.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS));

        memberListTwo.add(HMButton.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS)
                .withNavigateTo(BlockPage.class));

        memberListTwo.add(HMButton.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(BlockPage.class));


        HMSubMenu demoSettings = leftMenu.add(HMSubMenu.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS));

        demoSettings.add(HMButton.get()
                .withCaption("White Theme")
                .withIcon(VaadinIcon.PALETE)
                .withClickListener(e -> switchTheme(DesignItem.getWhiteDesign())));

        demoSettings.add(HMButton.get()
                .withCaption("Dark Theme")
                .withIcon(VaadinIcon.PALETE)
                .withClickListener(e -> switchTheme(DesignItem.getDarkDesign())));

        demoSettings.add(HMButton.get()
                .withCaption("Minimal")
                .withIcon(VaadinIcon.COG)
                .withClickListener(e -> getLeftMenu().toggleSize()));

        return true; // build menu
    }
}
