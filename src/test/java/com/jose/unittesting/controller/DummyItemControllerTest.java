package com.jose.unittesting.controller;

import com.jose.unittesting.business.ItemBusinessService;
import com.jose.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class DummyItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    void dummyItemBasic() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": \"Ball\",\n" +
                        "  \"price\": 10,\n" +
                        "  \"quantity\": 100\n" +
                        "}"))
                .andReturn();
        // .andExpect(content().json("Hello world!"))
        //verify hello world
        //assertEquals("Hello world!",result.getResponse().getContentAsString());
    }

    @Test
    void itemFromBusinessService_basic() throws Exception {
        Mockito.when(itemBusinessService.retrieveHardcodedItem()).thenReturn(
                new Item(2,"Item 2",10,10)
        );

        RequestBuilder request= MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"name\": \"Item 2\",\n" +
                        "  \"price\": 10,\n" +
                        "  \"quantity\": 10\n" +
                        "}"))
                .andReturn();
        // .andExpect(content().json("Hello world!"))
        //verify hello world
        //assertEquals("Hello world!",result.getResponse().getContentAsString());
    }
}