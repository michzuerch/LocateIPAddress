package com.gmail.michzuerch.locateipaddress.frontend.formdialog;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.frontend.page.BlockPage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockFormDialog extends Dialog {
    private static final Logger logger = LoggerFactory.getLogger(BlockFormDialog.class);

    @Autowired
    BlockRepository repository;

    BeanValidationBinder<Block> binder = new BeanValidationBinder<>(Block.class);
    private Block bean = new Block();
    private BlockPage page;
    private FormLayout layout = new FormLayout();
    private TextField network = new TextField("Geoname Id");
    private TextField geonameId = new TextField("Locale Code");
    private TextField registeredCountryGeonameId = new TextField("Continent Code");
    private TextField representedCountryGeonameId = new TextField("Continent Name");
    private TextField isAnonymous = new TextField("Country ISO Code");
    private TextField isSatelliteProvider = new TextField("Country Name");
    private TextField postalCode = new TextField("Subdivision 1 ISO Code");
    private TextField latitude = new TextField("Subdivision 1 Name");
    private TextField longitude = new TextField("Subdivision 2 ISO Code");
    private TextField accuracyRadius = new TextField("Subdivision 2 Name");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button cancel = new Button("Cancel");

    public BlockFormDialog(BlockPage page) {
        init();
        this.page = page;
    }

    private BeanValidationBinder<Block> getBinder() {
        return binder;
    }

    private void init() {
        logger.debug("init");
        binder.bindInstanceFields(this);
        save.getElement().setAttribute("theme", "primary");

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
        cancel.addClickListener(e -> this.close());


        layout.add(network, geonameId, registeredCountryGeonameId,
                representedCountryGeonameId, isAnonymous,
                isSatelliteProvider, postalCode,
                latitude, longitude, accuracyRadius, cancel, delete, save);

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
