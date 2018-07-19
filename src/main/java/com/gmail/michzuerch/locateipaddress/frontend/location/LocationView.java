package com.gmail.michzuerch.locateipaddress.frontend.location;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@Route("location")
@UIScope
public class LocationView extends VerticalLayout {
    private LocationRepository locationRepository;
    private Grid<Location> grid = new Grid<>();
    private LocationForm form = new LocationForm(this);

    private Button addCustomerBtn = new Button("Add");

    private TextField filterText = new TextField();
    private Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));

    public LocationView(@Autowired LocationRepository locationRepository) {
        this.locationRepository = locationRepository;

        filterText.setPlaceholder("Filter by city...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());
        clearFilterTextBtn.addClickListener(e -> {
            filterText.clear();
            updateList();
        });

        grid.setSizeFull();
        grid.addColumn(Location::getId).setSortable(true).setHeader("Id");
        grid.addColumn(location -> String.valueOf(location.getBlocks().size())).setHeader("Blocks");
        grid.addColumn(Location::getCity).setSortable(true).setHeader("City");
        grid.addColumn(Location::getCityName).setHeader("CityName");
        grid.addColumn(Location::getContinentName).setHeader("ContinentName");
        grid.addColumn(Location::getContinentCode).setHeader("Continent Code");
        grid.addColumn(Location::getCountryName).setHeader("CountryName");
        grid.addColumn(Location::getSubdivision1name).setHeader("Sd1Name");
        grid.addColumn(Location::getSubdivision1isoCode).setHeader("Sd1Iso");
        grid.addColumn(Location::getSubdivision2name).setHeader("Sd2Name");
        grid.addColumn(Location::getSubdivision2isoCode).setHeader("Sd2Iso");
        grid.addColumn(Location::getCountryIsoCode).setHeader("Coutry Iso");
        grid.addColumn(Location::getGeonameId).setHeader("GeonameId");
        grid.addColumn(Location::getIsInEuropeanUnion).setHeader("isEU");
        grid.addColumn(Location::getLocaleCode).setHeader("LocaleCode");
        grid.addColumn(Location::getMetroCode).setHeader("Metrocode");
        grid.addColumn(Location::getPostalcode).setHeader("Postalcode");
        grid.addColumn(Location::getTimeZone).setHeader("Timezone");
        grid.addColumn(Location::getLatitude).setHeader("Latitude");
        grid.addColumn(Location::getLongitude).setHeader("Longitude");

        HorizontalLayout filtering = new HorizontalLayout(filterText, clearFilterTextBtn);
        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setLocation(new Location());
        });
        grid.asSingleSelect().addValueChangeListener(event -> {
            form.setLocation(event.getValue());
        });

        add(toolbar, main);
        setHeight("100vh");
        updateList();
    }

    public void updateList() {
        if (filterText.isEmpty()) {
            grid.setItems(locationRepository.findAll());
        } else {
            grid.setItems(locationRepository.findByCityIgnoreCase(filterText.getValue() + "%"));
        }
    }
}
