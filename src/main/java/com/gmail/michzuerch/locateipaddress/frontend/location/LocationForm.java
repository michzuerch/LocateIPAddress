package com.gmail.michzuerch.locateipaddress.frontend.location;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationForm extends FormLayout {

    private TextField locationId = new TextField("Location Id");
    private TextField continentName = new TextField("Continent Name");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    @Autowired
    private LocationRepository locationRepository;

    private LocationView view;
    private Location location;
    private Binder<Location> binder = new Binder<>(Location.class);

    public LocationForm(LocationView view) {
        this.view = view;
        binder.bindInstanceFields(this);
        save.getElement().setAttribute("theme", "primary");
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());

        add(locationId, continentName, buttons);
        setLocation(null);
    }

    private void delete() {
        locationRepository.delete(location);
        view.updateList();
        setLocation(null);
    }

    private void save() {
        locationRepository.save(location);
        view.updateList();
        setLocation(null);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        binder.setBean(location);
        boolean enabled = location != null;
        save.setEnabled(enabled);
        delete.setEnabled(enabled);
        if (enabled) {
            locationId.focus();
        }
    }
}
