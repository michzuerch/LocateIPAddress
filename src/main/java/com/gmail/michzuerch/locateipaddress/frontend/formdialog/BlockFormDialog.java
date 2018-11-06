package com.gmail.michzuerch.locateipaddress.frontend.formdialog;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.frontend.page.BlockPage;
import com.storedobject.vaadin.BigDecimalField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockFormDialog extends Dialog {
    private static final Logger logger = LoggerFactory.getLogger(BlockFormDialog.class);

    @Autowired
    BlockRepository repository;

    Binder<Block> binder = new Binder<>(Block.class);
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
    private BigDecimalField startip = new BigDecimalField("Start IP");
    private BigDecimalField endip = new BigDecimalField("End IP");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button cancel = new Button("Cancel");

    public BlockFormDialog(BlockPage page, Block bean) {
        this.page = page;
        this.bean = bean;
        init();
    }

    private void init() {
        logger.debug("init");
        binder.setBean(bean);
        binder.bindInstanceFields(this);
//        binder.forField(startip).withConverter(new StringToBigDecimalConverter("Must be BigDecimal"));
//        binder.forField(endip).withConverter(new StringToBigDecimalConverter("Must be BigDecimal"));
        save.getElement().setAttribute("theme", "primary");

        binder.forField(network).asRequired("Block must have a network");

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
        cancel.addClickListener(e -> this.close());


        layout.add(network, geonameId, registeredCountryGeonameId,
                representedCountryGeonameId, isAnonymous,
                isSatelliteProvider, postalCode,
                latitude, longitude, accuracyRadius, startip, endip,
                cancel, delete, save);

        add(layout);
        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
    }

    private void delete() {
        bean = binder.getBean();
        repository.delete(bean);
        page.updateList();
    }

    private void save() {
        //bean = binder.readBean();
        logger.debug("Bean:" + bean.toString());
        repository.save(bean);
        page.updateList();
    }
}
