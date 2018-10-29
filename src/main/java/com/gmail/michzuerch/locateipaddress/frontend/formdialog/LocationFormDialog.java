package com.gmail.michzuerch.locateipaddress.frontend.formdialog;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.gmail.michzuerch.locateipaddress.frontend.page.LocationPage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationFormDialog extends Dialog {
    private static final Logger logger = LoggerFactory.getLogger(LocationFormDialog.class);

    @Autowired
    LocationRepository repository;

    BeanValidationBinder<Location> binder = new BeanValidationBinder<>(Location.class);
    private Location bean = new Location();
    private LocationPage page;
    private FormLayout layout = new FormLayout();
    private TextField geonameId = new TextField("Geoname Id");
    private TextField localeCode = new TextField("Locale Code");
    private TextField continentCode = new TextField("Continent Code");
    private TextField continentName = new TextField("Continent Name");
    private TextField countryIsoCode = new TextField("Country ISO Code");
    private TextField countryName = new TextField("Country Name");
    private TextField subdivision1isoCode = new TextField("Subdivision 1 ISO Code");
    private TextField subdivision1name = new TextField("Subdivision 1 Name");
    private TextField subdivision2isoCode = new TextField("Subdivision 2 ISO Code");
    private TextField subdivision2name = new TextField("Subdivision 2 Name");
    private TextField cityName = new TextField("City Name");
    private TextField metroCode = new TextField("Metro Code");
    private TextField timeZone = new TextField("Timezone");
    private TextField isInEuropeanUnion = new TextField("is in European Union");
    private TextField country = new TextField("Country");
    private TextField city = new TextField("City");
    private TextField postalcode = new TextField("Postalcode");
    private TextField latitude = new TextField("Latitude");
    private TextField longitude = new TextField("Longitude");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button cancel = new Button("Cancel");

    public LocationFormDialog(LocationPage page) {
        this.page = page;
        init();
    }

    private BeanValidationBinder<Location> getBinder() {
        return binder;
    }

    private void init() {
        logger.debug("init");
        binder.bindInstanceFields(this);
        save.getElement().setAttribute("theme", "primary");

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
        cancel.addClickListener(e -> this.close());


        layout.add(geonameId, localeCode, continentCode, continentName, countryIsoCode, countryName, subdivision1isoCode,
                subdivision1name, subdivision2isoCode, subdivision2name, cityName, metroCode, timeZone, isInEuropeanUnion,
                country, city, postalcode, longitude, latitude, cancel, delete, save);

        add(layout);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
    }

    private void delete() {
        repository.delete(bean);
        page.updateList();
    }

    private void save() {
        repository.save(bean);
        page.updateList();
    }
}
