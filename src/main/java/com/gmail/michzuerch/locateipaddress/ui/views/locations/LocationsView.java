package com.gmail.michzuerch.locateipaddress.ui.views.locations;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;

import com.gmail.michzuerch.locateipaddress.backend.data.Role;
import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.crud.AbstractBakeryCrudView;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.Location;
import com.gmail.michzuerch.locateipaddress.backend.service.LocationService;
import com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst;
import com.gmail.michzuerch.locateipaddress.ui.utils.converters.CurrencyFormatter;

import static com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst.PAGE_LOCATIONS;

import com.gmail.michzuerch.locateipaddress.app.security.CurrentUser;

@Route(value = PAGE_LOCATIONS, layout = MainView.class)
@PageTitle(I18nConst.TITLE_LOCATIONS)
@Secured(Role.ADMIN)
public class LocationsView extends Div {
	private static final long serialVersionUID = 1L;
	@Autowired
	public LocationsView(LocationService service, CurrentUser currentUser) {
        Grid<Location> grid = new Grid<>(Location.class,false);
        grid.addColumns("id","localeCode","continentCode","continentName","countryIsoCode","countryName","cityName");
        grid.setItems(service.getRepository().findAll());
        add(grid);
	}


}