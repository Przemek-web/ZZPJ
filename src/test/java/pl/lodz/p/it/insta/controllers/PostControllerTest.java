package pl.lodz.p.it.insta.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "ObiKenobi14", password = "Duch123")
public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAll() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/posts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(9)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description", is("Pierwszy raz na murze, ale wysoko")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].account.username", is("ObiKenobi14")));
    }
}