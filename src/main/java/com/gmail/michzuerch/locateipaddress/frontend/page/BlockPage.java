package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value = "Block", layout = MainLayout.class)
public class BlockPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(BlockPage.class);

    @Autowired
    BlockRepository blockRepository;

    Grid<Block> grid = new Grid<Block>(Block.class);

    @PostConstruct
    private void init() {
        grid.setItems(blockRepository.findAll());

        add(grid);
    }
}
