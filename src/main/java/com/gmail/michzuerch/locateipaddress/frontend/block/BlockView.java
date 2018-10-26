package com.gmail.michzuerch.locateipaddress.frontend.block;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Route("block")
@UIScope
public class BlockView extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(BlockView.class);

    private BlockRepository blockRepository;
    private Grid<Block> grid = new Grid<>();
    private BlockForm form = new BlockForm(this);

    private Button addBlockBtn = new Button("Add");

    private TextField filterText = new TextField();
    private Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));

    public BlockView(@Autowired BlockRepository blockRepository) {
        this.blockRepository = blockRepository;

        filterText.setPlaceholder("Filter by Postalcode...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());
        clearFilterTextBtn.addClickListener(e -> {
            filterText.clear();
            updateList();
        });

        grid.setSizeFull();
        grid.addColumn(Block::getGeonameId).setSortable(true).setHeader("Geoname Id");
        grid.addColumn(Block::getNetwork).setHeader("Network");
        grid.addColumn(Block::getRegisteredCountryGeonameId).setHeader("Reg Count Geoname Id");
        grid.addColumn(Block::getRepresentedCountryGeonameId).setHeader("Rep Count Geoname Id");
        grid.addColumn(Block::getIsAnonymousProxy).setHeader("Anonymous Proxy");
        grid.addColumn(Block::getIsSatelliteProvider).setHeader("Satellite");
        grid.addColumn(Block::getPostalCode).setHeader("Postalcode");
        grid.addColumn(Block::getLatitude).setHeader("Latitude");
        grid.addColumn(Block::getLongitude).setHeader("Longitude");
        grid.addColumn(Block::getAccuracyRadius).setHeader("Accuracy Radius");

        HorizontalLayout filtering = new HorizontalLayout(filterText, clearFilterTextBtn);
        HorizontalLayout toolbar = new HorizontalLayout(filtering, addBlockBtn);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        addBlockBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setBlock(new Block());
        });
        grid.asSingleSelect().addValueChangeListener(event -> {
            form.setBlock(event.getValue());
        });

        add(toolbar, main);
        setHeight("100vh");
        updateList();
    }

    public void updateList() {
        if (filterText.isEmpty()) {
            grid.setItems(blockRepository.findAll());
        } else {
            logger.debug("findByPostalCode(" + filterText.getValue() + ")");
            grid.setItems(blockRepository.findByPostalCodeContainingIgnoreCase(filterText.getValue()));
        }
    }
}
