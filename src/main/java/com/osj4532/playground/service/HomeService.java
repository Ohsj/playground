package com.osj4532.playground.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService extends BaseService {
    public String playground() {
        logger.info("Base Service logger");
        return "This is PlayGround";
    }
}
