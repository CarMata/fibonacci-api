package com.fibonacci.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fibonacci.api.controller.FibonacciController;

@WebMvcTest(FibonacciController.class)
class FibonacciApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciController fibonacciController;

    @Test
    public void testGetFibonacci() throws Exception {
        int inputNumber = 3;
        mockMvc.perform(get("/fibonacci").param("n", String.valueOf(inputNumber))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }
}
