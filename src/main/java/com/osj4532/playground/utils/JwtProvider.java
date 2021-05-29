package com.osj4532.playground.utils;

import com.osj4532.playground.domain.entity.UserMst;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
    public String createToken(UserMst user) {

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

    // 토큰 만료 체크
    public boolean isTokenExpired(String token) {
        long now = new Date().getTime() / 1000; // millisecond remove
        long exp = Long.parseLong(String.valueOf(getTokenData(token).get("exp")));
        System.out.println(now +" , " + exp);

        return now > exp;
    }
}
