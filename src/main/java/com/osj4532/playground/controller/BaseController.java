package com.osj4532.playground.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
}
