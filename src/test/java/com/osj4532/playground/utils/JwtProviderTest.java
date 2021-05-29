package com.osj4532.playground.utils;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.domain.repo.UserRepo;
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
    private UserRepo repo;

    @Test
    void createToken() throws Exception {

        UserMst user = repo.findById("USR0001").orElseThrow(Exception::new);

        String token = jwtProvider.createToken(user);
        System.out.println(token);

        assertThat(token)
                .isNotEmpty();
    }

    @Test
    void getTokenData() throws Exception {
        UserMst user = repo.findById("USR0001").orElseThrow(Exception::new);
        String token = jwtProvider.createToken(user);

        Map<String, Object> tokenData = jwtProvider.getTokenData(token);
        System.out.println(tokenData.toString());
        assertThat(tokenData).hasSize(6);
    }

    @Test
    void isTokenExpired() throws Exception {
        UserMst user = repo.findById("USR0001").orElseThrow(Exception::new);
        String token = jwtProvider.createToken(user);

        boolean isExpired = jwtProvider.isTokenExpired(token);
        System.out.println(isExpired);
        assertThat(isExpired).isFalse();
    }
}
