package com.osj4532.playground;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication(
        scanBasePackages = {"com.osj4532.playground"}
)
public class AppMain {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(AppMain.class);
        springApp.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext app = springApp.run(args);
        Environment env = app.getEnvironment();
        List<String> beans = Arrays.stream(app.getBeanDefinitionNames()).collect(Collectors.toList());
        String activeProfiles = String.join(", ", env.getActiveProfiles());

        logger.info("=======================================================================================");
        logger.info("Loaded Beans Count  : " + beans.size());
        logger.info("Active Profiles (" + env.getActiveProfiles().length + ") : " + activeProfiles);
        logger.info("=======================================================================================");

    }

}
