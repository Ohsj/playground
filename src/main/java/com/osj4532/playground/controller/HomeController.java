package com.osj4532.playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 210417 | osj4532 | created
 */

@RestController
@RequestMapping("/")
public class HomeController extends BaseController{
    @GetMapping
    public String playground() {
        logger.trace("This is PlayGround");
        logger.debug("This is PlayGround");
        logger.info("This is PlayGround");
        logger.warn("This is PlayGround");
        logger.error("This is PlayGround");

        return "This is PlayGround";
    }
}
