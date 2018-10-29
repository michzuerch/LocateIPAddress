package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.frontend.formdialog.BlockFormDialog;
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

@Route(value = "Block", layout = MainLayout.class)
@UIScope
public class BlockPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(BlockPage.class);

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
            dialog = new BlockFormDialog(this);
            dialog.open();
        });
        add(toolbar, grid);
    }

    public void updateList() {
        if (filterText.isEmpty()) {
            grid.setItems(blockRepository.findAll());
            logger.debug("findAll()");
        } else {
            grid.setItems(blockRepository.findByPostalCodeContainingIgnoreCase(filterText.getValue() + "%"));
            logger.debug("findByCityIgnoreCase(" + filterText.getValue() + "):" +
                    blockRepository.findByPostalCodeContainingIgnoreCase(filterText.getValue() + "%").size());
        }
    }
}
