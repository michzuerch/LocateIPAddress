package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.gmail.michzuerch.locateipaddress.config.LocateIPAddressConfiguration;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.util.HasLogger;
import com.gmail.michzuerch.locateipaddress.util.HasNotifications;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import de.kaesdingeling.hybridmenu.components.NotificationCenter;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Route(value = "DatabaseTest", layout = MainLayout.class)
public class DatabaseTestPage extends VerticalLayout implements HasLogger, HasNotifications {
    private Button btnCreateTestdata;
    private Button btnReadTestdata;
    private Button btnRemoveTestdata;
    private Button btnRelations;
    private final LocateIPAddressConfiguration locateIPAddressConfiguration;


    private final LocationRepository locationRepository;
    private final BlockRepository blockRepository;
    private Button btnLogger;


    public DatabaseTestPage(LocationRepository locationRepository, BlockRepository blockRepository,
                            LocateIPAddressConfiguration locateIPAddressConfiguration) {
        this.locationRepository = locationRepository;
        this.blockRepository = blockRepository;
        this.locateIPAddressConfiguration = locateIPAddressConfiguration;
    }

    protected void createTestdata() {
        Location location1 = Location.builder()
                .city("Singen")
                .cityName("Singen")
                .continentCode("EU")
                .continentName("Europe")
                .country("Estonia")
                .countryIsoCode("EE")
                .geonameId("GeonameId")
                .isInEuropeanUnion("Y")
                .latitude(new BigDecimal(345))
                .longitude(new BigDecimal(33452))
                .metroCode("MC")
                .postalcode("3423")
                .subdivision1isoCode("sd1iso")
                .subdivision1name("sd1name")
                .subdivision2isoCode("sd2iso")
                .subdivision2name("sd2name")
                .timeZone("UTZ").build();


        Location location2 = Location.builder()
                .city("München")
                .cityName("München")
                .continentCode("EU")
                .continentName("Europe")
                .country("Estonia")
                .countryIsoCode("EE")
                .geonameId("GeonameId")
                .isInEuropeanUnion("Y")
                .latitude(new BigDecimal(345))
                .longitude(new BigDecimal(33452))
                .metroCode("MC")
                .postalcode("3423")
                .subdivision1isoCode("sd1iso")
                .subdivision1name("sd1name")
                .subdivision2isoCode("sd2iso")
                .subdivision2name("sd2name")
                .timeZone("UTZ").build();


        Block block1 = Block.builder()
                .startip(new BigDecimal(234))
                .endip(new BigDecimal(23))
                .accuracyRadius("Accuracy")
                .geonameId("GeonameId")
                .isAnonymousProxy("N")
                .isSatelliteProvider("N")
                .latitude("lat")
                .longitude("long")
                .network("network")
                .postalCode("23423")
                .registeredCountryGeonameId("rceid")
                .representedCountryGeonameId("repcgid").build();

        Block block2 = Block.builder()
                .startip(new BigDecimal(234))
                .endip(new BigDecimal(23))
                .accuracyRadius("Accuracy")
                .geonameId("GeonameId")
                .isAnonymousProxy("N")
                .isSatelliteProvider("N")
                .latitude("lat")
                .longitude("long")
                .network("network")
                .postalCode("23423")
                .registeredCountryGeonameId("rceid")
                .representedCountryGeonameId("repcgid").build();

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


            locationRepository.findAll().forEach(location -> {
                Notification.show("Block:" + location);
                //Notification.show("Blocks: "+location.getBlocks().size());
            });

            showNotification(locateIPAddressConfiguration.getProp());
        });

        btnLogger = new Button("Test Logger", event -> {
            getLogger().debug("Debug");
            getLogger().error("Error");
            getLogger().info("Info");
        });

        add(btnCreateTestdata, btnReadTestdata, btnRelations, btnRemoveTestdata, btnLogger);
    }
}
