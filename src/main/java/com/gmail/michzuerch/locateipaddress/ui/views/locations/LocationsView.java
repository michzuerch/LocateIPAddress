package com.gmail.michzuerch.locateipaddress.ui.views.locations;

import com.gmail.michzuerch.locateipaddress.app.security.CurrentUser;
import com.gmail.michzuerch.locateipaddress.backend.data.Role;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.Location;
import com.gmail.michzuerch.locateipaddress.backend.service.LocationService;
import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import static com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst.PAGE_LOCATIONS;

@Route(value = PAGE_LOCATIONS, layout = MainView.class)
@PageTitle(I18nConst.TITLE_LOCATIONS)
@Secured(Role.ADMIN)
public class LocationsView extends Div {
    private static final long serialVersionUID = 1L;

    @Autowired
    public LocationsView(LocationService service, CurrentUser currentUser) {
        Grid<Location> grid = new Grid<>(Location.class, false);
        grid.addColumns("id", "localeCode", "continentCode", "continentName", "countryIsoCode", "countryName", "cityName");
        grid.setItems(service.getRepository().findAll());
        add(grid);
    }


}