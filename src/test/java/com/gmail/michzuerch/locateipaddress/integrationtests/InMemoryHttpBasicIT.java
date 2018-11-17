package com.gmail.michzuerch.locateipaddress.integrationtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DisplayName("Test Security Basic Authentication")
public class InMemoryHttpBasicIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("accessProtected")
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(unauthenticated())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("loginUser")
    public void loginUser() throws Exception {
        this.mockMvc.perform(get("/api")
                .with(httpBasic("michzuerch", "lx0lc33a")))
                .andExpect(status().isOk());
    }

//    @Test
//    public void loginInvalidUser() throws Exception {
//        this.mockMvc.perform(formLogin().user("invalid").password("invalid"))
//                .andExpect(unauthenticated());
//    }

}
