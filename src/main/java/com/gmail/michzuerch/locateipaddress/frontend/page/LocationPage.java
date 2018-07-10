package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.repository.mongodb.LocationRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.frontend.formdialog.LocationFormDialog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value = "Location", layout = MainLayout.class)
public class LocationPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(LocationPage.class);

    @Autowired
    LocationRepository locationRepository;

    Grid<Location> grid = new Grid<Location>(Location.class);
    Button btnAdd = new Button("Neu");
    LocationFormDialog formDialog = new LocationFormDialog();

    @PostConstruct
    private void init() {
        grid.setItems(locationRepository.findAll());

        btnAdd.addClickListener(event -> {

            formDialog.open();

        });
        add(btnAdd, grid);
    }
}
