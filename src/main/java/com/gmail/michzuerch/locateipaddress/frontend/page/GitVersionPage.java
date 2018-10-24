package com.gmail.michzuerch.locateipaddress.frontend.page;

import com.gmail.michzuerch.locateipaddress.frontend.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

@Route(value = "GitVersion", layout = MainLayout.class)
public class GitVersionPage extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(com.gmail.michzuerch.locateipaddress.frontend.page.GitVersionPage.class);

    @Value("${git.commit.message.short}")
    private String commitMessage;

    @Value("${git.branch}")
    private String branch;

    @Value("${git.commit.id}")
    private String commitId;

    private Text txtCommitMessage = new Text(commitMessage);
    private Text txtBranch = new Text(branch);
    private Text txtCommitId = new Text(commitId);

    @PostConstruct
    private void init() {
        add(txtCommitMessage, txtBranch, txtCommitId);
    }
}
