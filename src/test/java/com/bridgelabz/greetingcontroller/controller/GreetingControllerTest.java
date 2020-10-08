package com.bridgelabz.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.service.IGreetingService;
import net.minidev.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IGreetingService service;


    @Test
    public void getAllGreetingMessageAPI()
    {
        try {
            MvcResult mvcResult = null;
            mvcResult = mvc.perform(get("/hello/all")
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn();
            when(service.findAllMessage()).thenReturn(new ArrayList<>());
            Assert.assertEquals(200, mvcResult.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}