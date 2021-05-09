package com.osj4532.playground.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 참고
 * 스프링 부트 2.0부터 Java8과 스프링 5.0을 사용하면서
 * WebMvcConfigurer 메서드에 default를 선언했다.
 * 그 덕분에 WebMvcConfigurer를 구현하는 클래스에서 모든 메서드를 구현해야하는 강제력이 사라졌다.
 * 그 결과 스프링 부트 2.0에서 WebMvcConfigurerAdapter 클래스는 제외(Deprecated)되었다.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
}
