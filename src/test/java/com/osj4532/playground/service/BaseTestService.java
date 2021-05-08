package com.osj4532.playground.service;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public abstract class BaseTestService {
    public final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
}
