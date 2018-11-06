package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.frontend.formdialog.BlockFormDialog;
import com.gmail.michzuerch.locateipaddress.util.HasLogger;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Route(value = "Block", layout = MainLayout.class)
@UIScope
public class BlockPage extends VerticalLayout implements HasLogger {

    @Autowired
    private BlockRepository blockRepository;

    private Grid<Block> grid = new Grid<>(Block.class);
    private Button btnAdd = new Button("Add");
    private TextField filterText = new TextField();
    private Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));
    private BlockFormDialog dialog;

    @PostConstruct
    private void init() {
        grid.setItems(blockRepository.findAll());
        filterText.setPlaceholder("Find by postalcode");

        filterText.addValueChangeListener(event -> updateList());
        clearFilterTextBtn.addClickListener(event -> {
            filterText.clear();
            updateList();
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText, clearFilterTextBtn, btnAdd);
        btnAdd.addClickListener(event -> {

            Block block = new Block();
            block.setLatitude("latitude");
            block.setAccuracyRadius("acuracy");
            block.setGeonameId("23");
            block.setIsAnonymousProxy("anonproxy");
            block.setNetwork("net");
            block.setIsSatelliteProvider("satprov");
            block.setPostalCode("452435");
            block.setRegisteredCountryGeonameId("countryid");
            block.setLongitude("longitude");
            block.setEndip(new BigDecimal(3453));
            block.setStartip(new BigDecimal(1231234));
            block.setRepresentedCountryGeonameId("repro");
            block.setId(new ObjectId());

            dialog = new BlockFormDialog(this, block);
            dialog.open();
        });
        add(toolbar, grid);
    }

    public void updateList() {
        if (filterText.isEmpty()) {
            grid.setItems(blockRepository.findAll());
            getLogger().debug("findAll()");
        } else {
            grid.setItems(blockRepository.findByPostalCodeContainingIgnoreCase(filterText.getValue() + "%"));
            getLogger().debug("findByCityIgnoreCase(" + filterText.getValue() + "):" +
                    blockRepository.findByPostalCodeContainingIgnoreCase(filterText.getValue() + "%").size());
        }
    }
}
