package com.osj4532.playground.config;

import com.osj4532.playground.aop.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 참고
 * 스프링 부트 2.0부터 Java8과 스프링 5.0을 사용하면서
 * WebMvcConfigurer 메서드에 default를 선언했다.
 * 그 덕분에 WebMvcConfigurer를 구현하는 클래스에서 모든 메서드를 구현해야하는 강제력이 사라졌다.
 * 그 결과 스프링 부트 2.0에서 WebMvcConfigurerAdapter 클래스는 제외(Deprecated)되었다.
 *
 * 210509 | osj4532 | created
 * 210523 | osj4532 | Auth interceptor add
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    public WebConfig(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
