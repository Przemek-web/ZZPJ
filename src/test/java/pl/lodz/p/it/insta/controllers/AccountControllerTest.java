package pl.lodz.p.it.insta.controllers;

import com.google.gson.Gson;
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
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    private Gson gson = new Gson();

    @Test
    public void getCurrentUserTest() throws Exception {
        //TODO naprawic
        /*mvc.perform( MockMvcRequestBuilders
                .get("/accounts/me")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", is("ObiKenobi14")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", is("Obi-Wan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is("Kenobi")));*/
    }

    @Test
    public void getUserProfileTest() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/accounts/Ksiezniczka123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", is("Ksiezniczka123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", is("Leia")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is("Organa")));
    }

    @Test
    public void checkUsernameAvailability() {
    }

    @Test
    public void checkEmailAvailability() {
    }
}