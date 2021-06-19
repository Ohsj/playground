package com.osj4532.playground.utils;

import com.osj4532.playground.dto.UserMstDto;
import com.osj4532.playground.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JwtProviderTest {
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserService service;

    @Test
    void createToken() {

        UserMstDto user = service.getUserOneById("USER0001");

        String token = jwtProvider.createToken(user);
        System.out.println(token);

        assertThat(token)
                .isNotEmpty();
    }

    @Test
    void getTokenData() {
        UserMstDto user = service.getUserOneById("USER0001");
        String token = jwtProvider.createToken(user);

        Map<String, Object> tokenData = jwtProvider.getTokenData(token);
        System.out.println(tokenData.toString());
        assertThat(tokenData).hasSize(6);
    }

    @Test
    void isTokenExpired() {
        UserMstDto user = service.getUserOneById("USER0001");
        String token = jwtProvider.createToken(user);

        boolean isExpired = jwtProvider.validToken(token);
        System.out.println(isExpired);
        assertThat(isExpired).isFalse();
    }
}
