package com.osj4532.playground.controller;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeControllerIntegrationTest extends BaseIntegrationTest {
    @Test
    void playground() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
