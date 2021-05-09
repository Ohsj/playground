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

/**
 * 참고) @SpringBootApplication
 * SpringBootApplication annotation 은 3가지의 Annotation이 합쳐진 것으로 볼수 있다.
 * 1. @Configuration
 * 2. @ComponentScan
 * 3. @EnableAutoConfiguration
 *
 * 참고) Lazy Initialization
 * 스프링에 정의된 빈들과 의존성들은 application context가 생성될 때 같이 생성된다.
 * 반대로, lazy Initialization을 설정하면, 빈은 필요할 경우만 의존성이 주입되고 생성된다.
 */

@SpringBootApplication(
        scanBasePackages = {"com.osj4532.playground"}
)
public class AppMain {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(AppMain.class);
        // spring banner off
        springApp.setBannerMode(Banner.Mode.OFF);
        // bean lazy init
        // springApp.setLazyInitialization(true);

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
