package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.frontend.formdialog.LocationFormDialog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value = "Location", layout = MainLayout.class)
@UIScope
public class LocationPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(LocationPage.class);

    @Autowired
    private LocationRepository locationRepository;

    private Grid<Location> grid = new Grid<Location>(Location.class);
    private Button btnAdd = new Button("Add");
    private TextField filterText = new TextField();
    private Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));
    private LocationFormDialog dialog;

    @PostConstruct
    private void init() {
        grid.setItems(locationRepository.findAll());
        filterText.setPlaceholder("Find by city");

        filterText.addValueChangeListener(event -> updateList());
        clearFilterTextBtn.addClickListener(event -> {
            filterText.clear();
            updateList();
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText, clearFilterTextBtn, btnAdd);
        btnAdd.addClickListener(event -> {
            dialog = new LocationFormDialog(this);
            dialog.open();
        });
        add(toolbar, grid);
    }

    public void updateList() {
        if (filterText.isEmpty()) {
            grid.setItems(locationRepository.findAll());
            logger.debug("findAll()");
        } else {
            grid.setItems(locationRepository.findByCityIgnoreCase(filterText.getValue() + "%"));
            logger.debug("findByCityIgnoreCase(" + filterText.getValue() + "):" +
                    locationRepository.findByCityIgnoreCase(filterText.getValue() + "%").size());
        }
    }
}
