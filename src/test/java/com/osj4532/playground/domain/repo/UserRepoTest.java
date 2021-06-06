package com.osj4532.playground.domain.repo;

import com.osj4532.playground.config.PostgresDataSourceConfig;
import com.osj4532.playground.domain.entity.UserMst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PostgresDataSourceConfig.class)
public class UserRepoTest {

    @Autowired
    private UserRepo repo;

    @Test
    @DisplayName("user Repo test")
    void findById() {
        // when
        UserMst user = repo.findById("USR0001").orElse(new UserMst());

        // then
        assertThat(user.getUserName()).isEqualTo("오승주");

        System.out.println(user);
    }

}
