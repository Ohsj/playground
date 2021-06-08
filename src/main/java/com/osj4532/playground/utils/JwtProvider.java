package com.osj4532.playground.utils;

import ch.qos.logback.classic.Logger;
import com.osj4532.playground.dto.UserMstDto;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 210529 | osj4532 | created
 */

@Component
public class JwtProvider {

    private final Logger logger = (Logger)LoggerFactory.getLogger(JwtProvider.class);
    // 토큰 기간 (하루)
    private final long TOKEN_VALID_PERIOD = 1000 * 60 * 60 * 24;
    // JWT 암호키
    @Value("${spring.auth.jwt.secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        // secretKey base64로 인코딩
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT token 생성
    public String createToken(UserMstDto user) {

        // JWT Header
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        // 토큰 발행 일자
        Date now = new Date();

        // Claims : JWT payload에 저장되는 정보 단위
        Claims claims = Jwts.claims().setSubject("User Token");
        claims.put("id", user.getUserId());
        claims.put("name", user.getUserName());
        claims.put("email", user.getEmail());
        claims.setIssuedAt(now);
        claims.setExpiration(new Date(now.getTime() + TOKEN_VALID_PERIOD));

        // Jwt 생성
        return Jwts.builder()
                .setHeader(headers)                                          // jwt header
                .setClaims(claims)                                           // 데이터
                .signWith(SignatureAlgorithm.HS256, secretKey)               // 암호화 알고리즘, secret
                .compact();
    }

    // 토큰 내부 정보 가져오기(Claims 정보를 가져온다.)
    public Map<String, Object> getTokenData(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // 토큰 유효성 체크
    public boolean validToken(String token) {
        if (StringUtils.isNotEmpty(token)) {
            try {
                Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            } catch (SignatureException e) {
                logger.error("Invalid JWT signature", e);
            } catch (MalformedJwtException e) {
                logger.error("Invalid JWT token", e);
            } catch (ExpiredJwtException e) {
                logger.error("Expired JWT token", e);
            } catch (UnsupportedJwtException e) {
                logger.error("Unsupported JWT token", e);
            } catch (IllegalArgumentException e) {
                logger.error("JWT claims string is empty", e);
            }
        }
        return true;
    }
}
