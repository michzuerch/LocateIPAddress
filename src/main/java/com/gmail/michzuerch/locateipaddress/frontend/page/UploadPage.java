package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.gmail.michzuerch.locateipaddress.util.ImportBlockAndLocation;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.List;

@Route(value = "Upload", layout = MainLayout.class)
public class UploadPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(UploadPage.class);

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    BlockRepository blockRepository;

    MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
    Upload upload = new Upload(buffer);
    Label status = new Label("Status");
    ProgressBar progressBar = new ProgressBar(1, 100, 1);
    ImportBlockAndLocation importTool = new ImportBlockAndLocation();
    private UploadThread thread;

    @PostConstruct
    private void init() {
        upload.setAcceptedFileTypes("application/zip");
        upload.setMaxFiles(1);

        upload.addSucceededListener(event -> {
            Notification.show("Upload:" + event.getMIMEType(), 1000, Notification.Position.MIDDLE);

            List<Location> listLocation = null;
            List<Block> listBlock = null;

//            try {
//                importTool.importFile(buffer.getInputStream(event.getFileName()).readAllBytes());
//
//                listLocation = importTool.getLocationList();
//                listBlock = importTool.getBlockList();
//
//
//                for (Block block : listBlock) {
//                    blockRepository.save(block);
//                }
//
//                for (Location location : listLocation) {
//                    Block val = blockRepository.findByGeonameId(location.getGeonameId());
//                    //val.setLocation(location);
//                    location.getBlocks().add(val);
//                    //blockRepository.save(location);
//                    //blockRepository.save(val);
//                }
//
//                locationRepository.saveAll(listLocation);
//                blockRepository.saveAll(listBlock);
//
//            } catch (IOException e) {
//                logger.error(e.getLocalizedMessage());
//            }

            thread.start();
            logger.debug("Upload successfull");
        });
        add(upload, progressBar, status);
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        // Start the data feed thread
        thread = new UploadThread(attachEvent.getUI(), this);
        //thread.start();
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        // Cleanup
        thread.interrupt();
        thread = null;
    }


    private class UploadThread extends Thread {
        private final UI ui;
        private final UploadPage view;

        private int count = 0;

        public UploadThread(UI ui, UploadPage view) {
            this.ui = ui;
            this.view = view;
        }

        @Override
        public void run() {
            try {
                // Update the data for a while
                while (count < 100) {
                    // Sleep to emulate background work
                    Thread.sleep(500);
                    String message = "This is update " + count++;
                    //log.debug(LocalTime.now().format(dateTimeFormatter));
                    ui.access(() -> {
                        view.progressBar.setValue(count);
                        view.status.setText(LocalTime.now().toString());
                    });
                }

                // Inform that we are done
                ui.access(() -> {
                    view.status.setText("Upload complete");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


