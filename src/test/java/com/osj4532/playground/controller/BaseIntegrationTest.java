package com.osj4532.playground.controller;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public abstract class BaseIntegrationTest {

    public final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    protected MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }
}
