package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Route(value = "GitVersion", layout = MainLayout.class)
public class GitVersionPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(com.gmail.michzuerch.locateipaddress.frontend.page.GitVersionPage.class);

    private Grid<GitProperty> gitPropertyGrid = new Grid<>(GitProperty.class);

    public GitVersionPage() {
        gitPropertyGrid.setSizeFull();
        gitPropertyGrid.setItems(readGitProperties());
        add(gitPropertyGrid);
    }

    private Collection<GitProperty> readGitProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("git.properties");

        Properties properties = new Properties();

        List<GitProperty> list = new ArrayList<>();

        try {
            properties.load(inputStream);
            Set<String> keys = properties.stringPropertyNames();

            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = properties.getProperty(key);
                list.add(new GitProperty(key, value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

    private class GitProperty {
        private String key;
        private String value;

        public GitProperty(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
