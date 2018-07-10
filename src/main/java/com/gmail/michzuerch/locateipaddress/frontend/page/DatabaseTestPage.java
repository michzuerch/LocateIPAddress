package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.repository.mongodb.BlockRepository;
import com.gmail.michzuerch.locateipaddress.backend.repository.mongodb.LocationRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import de.kaesdingeling.hybridmenu.components.NotificationCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Route(value = "DatabaseTest", layout = MainLayout.class)
public class DatabaseTestPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseTestPage.class);

    private Button btnCreateTestdata;
    private Button btnReadTestdata;
    private Button btnRemoveTestdata;
    private Button btnRelations;

    private LocationRepository locationRepository;
    private BlockRepository blockRepository;


    public DatabaseTestPage(@Autowired LocationRepository locationRepository, @Autowired BlockRepository blockRepository) {
        this.locationRepository = locationRepository;
        this.blockRepository = blockRepository;
    }

    protected void createTestdata() {
        Location location1 = new Location();
        location1.setCity("Singen");
        location1.setCityName("Singen");
        location1.setContinentCode("EU");
        location1.setContinentName("Europa");
        location1.setCountry("Estonia");
        location1.setCountryIsoCode("EE");
        location1.setContinentName("Estonia");
        location1.setGeonameId("GeonameID");
        location1.setIsInEuropeanUnion("Y");
        location1.setLatitude(new BigDecimal(34));
        location1.setLongitude(new BigDecimal(5234));
        location1.setMetroCode("mc");
        location1.setPostalcode("2342");
        location1.setSubdivision1isoCode("sd1iso");
        location1.setSubdivision1name("sd1name");
        location1.setSubdivision2isoCode("sd2iso");
        location1.setSubdivision2name("sd2name");
        location1.setTimeZone("UTZ");


        Location location2 = new Location();
        location2.setCity("Singen2");
        location2.setCityName("Singen2");
        location2.setContinentCode("EU");
        location2.setContinentName("Europa");
        location2.setCountry("Estonia");
        location2.setCountryIsoCode("EE");
        location2.setContinentName("Estonia");
        location2.setGeonameId("GeonameID");
        location2.setIsInEuropeanUnion("Y");
        location2.setLatitude(new BigDecimal(34));
        location2.setLongitude(new BigDecimal(5234));
        location2.setMetroCode("mc");
        location2.setPostalcode("2342");
        location2.setSubdivision1isoCode("sd1iso");
        location2.setSubdivision1name("sd1name");
        location2.setSubdivision2isoCode("sd2iso");
        location2.setSubdivision2name("sd2name");
        location2.setTimeZone("UTZ2");

        Block block1 = new Block();
        block1.setStartip(new BigDecimal(230));
        block1.setEndip(new BigDecimal(3452));
        block1.setAccuracyRadius("accuracy");
        block1.setGeonameId("GeonameId");
        block1.setIsAnonymousProxy("N");
        block1.setIsSatelliteProvider("N");
        block1.setLatitude("latitude");
        block1.setLongitude("longitude");
        block1.setNetwork("network");
        block1.setPostalCode("postalcode");
        block1.setRegisteredCountryGeonameId("registreredCountry");

        Block block2 = new Block();
        block2.setAccuracyRadius("accuracy");
        block2.setGeonameId("GeonameId");
        block2.setStartip(new BigDecimal(230));
        block2.setEndip(new BigDecimal(3452));
        block2.setIsAnonymousProxy("N");
        block2.setIsSatelliteProvider("N");
        block2.setLatitude("latitude");
        block2.setLatitude("longitude");
        block2.setNetwork("network");
        block2.setPostalCode("postalcode");
        block2.setRegisteredCountryGeonameId("registreredCountry");

        block1 = blockRepository.save(block1);
        block2 = blockRepository.save(block2);

        location1.addBlock(block1);
        location1.addBlock(block2);

        location1 = locationRepository.save(location1);
        location2 = locationRepository.save(location2);


    }

    @PostConstruct
    private void init() {
        btnCreateTestdata = new Button("Testdaten erstellen", event -> createTestdata());
        btnReadTestdata = new Button("Testdaten lesen", event -> {
            Notification.show("Anzahl Locations: " + locationRepository.findAll().size(), 3000, Notification.Position.MIDDLE);
            Notification.show("Anzahl Blocks: " + blockRepository.findAll().size(), 3000, Notification.Position.MIDDLE);
        });
        btnRemoveTestdata = new Button("Testdaten löschen", event -> {
            blockRepository.deleteAll();
            locationRepository.deleteAll();
            Notification.show("Testdaten gelöscht", 1000, Notification.Position.MIDDLE);
        });
        btnRelations = new Button("Relations", event -> {
            NotificationCenter notificationCenter = VaadinSession.getCurrent().getAttribute(NotificationCenter.class);

            de.kaesdingeling.hybridmenu.components.Notification notification = de.kaesdingeling.hybridmenu.components.Notification.get()
                    .withTitle("Relationen")
                    .withContent("Lesen aus MongoDB")
                    .withIcon(VaadinIcon.COGS)
                    .withDisplayTime(2000);
            notificationCenter.add(notification, true);


            locationRepository.findAll().stream().forEach(location -> {
                Notification.show("Block:" + location);
                //Notification.show("Blocks: "+location.getBlocks().size());
            });
        });

        add(btnCreateTestdata, btnReadTestdata, btnRelations, btnRemoveTestdata);
    }
}
