package com.osj4532.playground.service;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.domain.repo.UserRepo;
import com.osj4532.playground.dto.UserMstDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class UserServiceTest extends BaseTestService{
    @Mock
    UserRepo repo;

    @InjectMocks
    UserService service;

    @Test
    void getUserOne() throws ParseException {
        String birth = "1994-12-03";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fakeId = "USR0001";

        UserMst userEntity = new UserMst();
        userEntity.setUserId(fakeId);
        userEntity.setUserName("test");
        userEntity.setCreateUserId("ADMIN");
        userEntity.setBirthDt(sdf.parse(birth));
        userEntity.setEmail("test@test");
        userEntity.setPhoneNum("01011111111");

        // given
        given(repo.findById(fakeId)).willReturn(Optional.of(userEntity));

        // when
        UserMstDto user = service.getUserOneById(userEntity.getUserId());

        // then
        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isEqualTo(userEntity.getUserId());
        assertThat(user.getUserId()).isEqualTo(fakeId);
        assertThat(user.getUserName()).isEqualTo("test");
        assertThat(user.getBirthDt()).isEqualTo(sdf.parse(birth));
        assertThat(user.getEmail()).isEqualTo("test@test");
        assertThat(user.getCreateUserId()).isEqualTo("ADMIN");
        assertThat(user.getPhoneNum()).isEqualTo("01011111111");
    }
}
