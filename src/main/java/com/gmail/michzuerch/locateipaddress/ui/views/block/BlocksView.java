package com.gmail.michzuerch.locateipaddress.ui.views.block;

import com.gmail.michzuerch.locateipaddress.app.security.CurrentUser;
import com.gmail.michzuerch.locateipaddress.backend.data.Role;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.Block;
import com.gmail.michzuerch.locateipaddress.backend.service.BlockService;
import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import static com.gmail.michzuerch.locateipaddress.ui.i18n.I18nConst.PAGE_BLOCKS;

@Route(value = PAGE_BLOCKS, layout = MainView.class)
@PageTitle(I18nConst.TITLE_BLOCKS)
@Secured(Role.ADMIN)
public class BlocksView extends Div {
    private static final long serialVersionUID = 1L;

    @Autowired
    public BlocksView(BlockService service, CurrentUser currentUser) {
        Grid<Block> grid = new Grid<>(Block.class, false);
        grid.addColumns("id", "startip", "endip", "isAnonymousProxy", "isSatelliteProvider", "latitude", "longitude", "accuracyRadius");
        grid.setItems(service.getRepository().findAll());
        add(grid);
    }


}