package com.osj4532.playground.controller;

import com.osj4532.playground.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class HomeControllerMvcTest extends BaseMvcTest{

    @MockBean
    private HomeService service;

    /**
     * http call test
     */
    @Test
    void mockMvcPlayground() throws Exception {
        // given
        given(service.playground())
                .willReturn("This is PlayGround");
        //when
        //then
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
