//package com.osj4532.playground.utils;
//
//import ch.qos.logback.classic.Logger;
//import io.jsonwebtoken.*;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Base64;
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    @Value("spring.auth.jwt.secret-key")
//    private String secretKey;
//    private final long TOKEN_VALID_MILISECOND = 1000L * 60; // 10 시간
//
//    protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
//    private final UserDetailsService userDetailsService;
//
//    public JwtTokenProvider(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public String createToken(String userId) {
//        Claims claims = Jwts.claims().setSubject(userId);
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + TOKEN_VALID_MILISECOND))
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(getUserId(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getUserId(String token) {
//        return Jwts.parser().setSigningKey(secretKey)
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        return req.getHeader("Authorization");
//    }
//
//    public boolean validateToken(String jwtToken) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return false;
//    }
//}
