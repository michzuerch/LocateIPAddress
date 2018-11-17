package com.gmail.michzuerch.locateipaddress.smoketests;

import com.gmail.michzuerch.locateipaddress.backend.rest.SecurityTestRest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SmokeIT {

    @Autowired
    private SecurityTestRest controller;

    @Test
    @DisplayName("Example Service should work!")
    public void contexLoads() throws Exception {

        assertFalse(controller == null);
    }
}