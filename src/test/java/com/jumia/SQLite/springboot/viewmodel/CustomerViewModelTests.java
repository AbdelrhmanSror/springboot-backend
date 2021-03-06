package com.jumia.SQLite.springboot.viewmodel;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerViewModelTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApplicationIsUp() throws Exception {
        this.mockMvc.perform(get("/info")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testReadAllData() throws Exception {
        this.mockMvc.perform(get("/Customers")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testReadFilteredData() throws Exception {
        this.mockMvc.perform(get("/FilteredCustomers/?countryCode=237&state=0")).andDo(print()).andExpect(status().isOk());
    }

}