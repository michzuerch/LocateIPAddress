package com.gmail.michzuerch.locateipaddress.ui.views.admin.products;

import com.gmail.michzuerch.locateipaddress.app.security.CurrentUser;
import com.gmail.michzuerch.locateipaddress.backend.data.Role;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.Product;
import com.gmail.michzuerch.locateipaddress.backend.service.ProductService;
import com.gmail.michzuerch.locateipaddress.ui.MainView;
import com.gmail.michzuerch.locateipaddress.ui.config.Pages;
import com.gmail.michzuerch.locateipaddress.ui.crud.AbstractBakeryCrudView;
import com.gmail.michzuerch.locateipaddress.ui.utils.converters.CurrencyFormatter;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.Currency;

import static com.gmail.michzuerch.locateipaddress.ui.config.Pages.PAGE_PRODUCTS;

@Route(value = PAGE_PRODUCTS, layout = MainView.class)
@PageTitle(Pages.TITLE_PRODUCTS)
@Secured(Role.ADMIN)
public class ProductsView extends AbstractBakeryCrudView<Product> {

    private static final long serialVersionUID = 1L;
    private CurrencyFormatter currencyFormatter = new CurrencyFormatter();

    @Autowired
    public ProductsView(ProductService service, CurrentUser currentUser) {
        super(Product.class, service, new Grid<>(), createForm(), currentUser);
    }

    private static BinderCrudEditor<Product> createForm() {
        TextField name = new TextField("Product name");
        name.getElement().setAttribute("colspan", "2");
        TextField price = new TextField("Unit price");
        price.getElement().setAttribute("colspan", "2");

        FormLayout form = new FormLayout(name, price);

        BeanValidationBinder<Product> binder = new BeanValidationBinder<>(Product.class);

        binder.bind(name, "name");

        binder.forField(price).withConverter(new PriceConverter()).bind("price");
        price.setPattern("\\d+(\\.\\d?\\d?)?$");
        price.setPreventInvalidInput(true);

        String currencySymbol = Currency.getInstance(Pages.APP_LOCALE).getSymbol();
        price.setPrefixComponent(new Span(currencySymbol));

        return new BinderCrudEditor<Product>(binder, form);
    }

    @Override
    protected void setupGrid(Grid<Product> grid) {
        grid.addColumn(Product::getName).setHeader("Product Name").setFlexGrow(10);
        grid.addColumn(p -> currencyFormatter.encode(p.getPrice())).setHeader("Unit Price");
    }

    @Override
    protected String getBasePage() {
        return PAGE_PRODUCTS;
    }

}
