package com.osj4532.playground.aop;

import ch.qos.logback.classic.Logger;
import com.osj4532.playground.dto.UserMstDto;
import com.osj4532.playground.service.UserService;
import com.osj4532.playground.utils.JwtProvider;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * API 요청시 권한이 있는지 체크
 * <p>
 * 210523 | osj4532 | created
 */
@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private long start = 0;

    public AuthInterceptor(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        logger.info("AuthInterceptor Start");
        start = System.currentTimeMillis();         // 시간 측정 용

        return isValidToken(req);
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) {
        long end = System.currentTimeMillis();
        logger.info("AuthInterceptor End" + " ( " + (end - start) + " ms )");
    }

    // 토큰 유효성 체크
    private boolean isValidToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        logger.info("token : " + token);

        boolean isValidToken = false;
        boolean isNameMatch = false;
        boolean isEmailMatch = false;

        if (StringUtils.isNotEmpty(token)) {
            // 토큰 데이터 추출
            Map<String, Object> tokenData = jwtProvider.getTokenData(token);
            // Id로 유저 조회
            UserMstDto user = userService.getUserOne(String.valueOf(tokenData.get("id")));

            // 토큰 유효 검사
            isValidToken = jwtProvider.validToken(token);
            // 토큰 데이터 동일 검사
            isNameMatch = user.getUserName().equals(String.valueOf(tokenData.get("name")));
            isEmailMatch = user.getEmail().equals(String.valueOf(tokenData.get("email")));
        }
        return isNameMatch && isEmailMatch && isValidToken;
    }
}
