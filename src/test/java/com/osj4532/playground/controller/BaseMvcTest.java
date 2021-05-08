package com.osj4532.playground.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class BaseMvcTest {

    public final Logger logger = (Logger)LoggerFactory.getLogger(getClass());

    // 모의 http request, response 만들어 테스트 진행하도록 해준다.
    @Autowired
    protected MockMvc mockMvc;

}
