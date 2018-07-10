package com.gmail.michzuerch.locateipaddress.frontend.block;

import com.gmail.michzuerch.locateipaddress.backend.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.repository.mongodb.BlockRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockForm extends FormLayout {

    private TextField blockId = new TextField("Block Id");
    private TextField geonameId = new TextField("GeonameId");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    @Autowired
    private BlockRepository blockRepository;

    private BlockView view;
    private Block block;
    private Binder<Block> binder = new Binder<>(Block.class);

    public BlockForm(BlockView view) {
        this.view = view;
        binder.bindInstanceFields(this);
        save.getElement().setAttribute("theme", "primary");
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());

        add(blockId, geonameId, buttons);
        setBlock(null);
    }

    private void delete() {
        blockRepository.delete(block);
        view.updateList();
        setBlock(null);
    }

    private void save() {
        blockRepository.save(block);
        view.updateList();
        setBlock(null);
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
        binder.setBean(block);
        boolean enabled = block != null;
        save.setEnabled(enabled);
        delete.setEnabled(enabled);
        if (enabled) {
            blockId.focus();
        }
    }
}
