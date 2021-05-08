package com.osj4532.playground.service;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
}
