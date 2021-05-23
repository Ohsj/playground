package com.osj4532.playground.domain.repo;

import com.osj4532.playground.domain.entity.UserMst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    private UserRepo repo;

    @Test
    void findById() {
        // when
        UserMst user = repo.findById("USR0001").get();

        // then
        assertThat(user.getUserName()).isEqualTo("오승주");

        System.out.println(user);
    }

}
