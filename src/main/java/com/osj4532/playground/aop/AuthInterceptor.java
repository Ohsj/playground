package com.osj4532.playground.aop;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API 요청시 권한이 있는지 체크
 *
 * 210523 | osj4532 | created
 */
@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private final StopWatch stopWatch = new StopWatch();

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        logger.info("AuthInterceptor Start");
        stopWatch.start();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) {
        stopWatch.stop();
        logger.info("AuthInterceptor End" + " ( " + stopWatch.getTotalTimeMillis() + " ms )");
    }
}
