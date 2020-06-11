package pl.lodz.p.it.insta.controllers;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.lodz.p.it.insta.dtos.EditTopicDto;
import pl.lodz.p.it.insta.security.payloads.LoginRequest;
import pl.lodz.p.it.insta.security.payloads.SignUpRequest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    private Gson gson = new Gson();

    @Test
    public void authenticateUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new LoginRequest("ObiKenobi14", "Duch123"))))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                .post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new LoginRequest("NieMaGo", "NoNieMa"))))
                .andExpect(status().is(401));
    }

    @Test
    public void registerUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new SignUpRequest("ObiKenobi14", "Obi", "Kenobi", "Duch123123", "Email123@wp.pl"))))
                .andExpect(status().is(400));

        mvc.perform(MockMvcRequestBuilders
                .post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new SignUpRequest("ObiKenobi11", "Obi", "Kenobi", "Duch123123", "Email123@wp.pl"))))
                .andExpect(status().isCreated());

        mvc.perform(MockMvcRequestBuilders
                .post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new SignUpRequest("ObiKenobi99", "Obi", "Kenobi", "Duch123123", "Email123@wp.pl"))))
                .andExpect(status().is(400));

        mvc.perform(MockMvcRequestBuilders
                .post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new SignUpRequest("ObiKenobi99", "", "Kenobi", "Duch123123", "Email11@wp.pl"))))
                .andExpect(status().is(400));
    }

    @Test
    public void accessDeniedTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/forum")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}