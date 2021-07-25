package com.osj4532.playground.mapstruct;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.dto.UserMstDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMstMapperTest {
    @Test
    void entityToDto() {
        Date now = new Date();

        UserMst entity = new UserMst();
        entity.setUserName("test");
        entity.setEmail("test@test");
        entity.setPhoneNum("01011111111");
        entity.setBirthDt(now);
        entity.setCreateUserId("USR0001");

        UserMstMapper mapper = Mappers.getMapper(UserMstMapper.class);
        UserMstDto user = mapper.toDto(entity);

        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo("test");
        assertThat(user.getEmail()).isEqualTo("test@test");
        assertThat(user.getPhoneNum()).isEqualTo("01011111111");
        assertThat(user.getBirthDt()).isEqualTo(now);
        assertThat(user.getCreateUserId()).isEqualTo("USR0001");
    }

    @Test
    void dtoToEntity() {
        Date now = new Date();

        UserMstDto dto = new UserMstDto();
        dto.setUserName("test");
        dto.setEmail("test@test");
        dto.setPhoneNum("01011111111");
        dto.setBirthDt(now);
        dto.setCreateUserId("USR0001");

        UserMstMapper mapper = Mappers.getMapper(UserMstMapper.class);
        UserMst user = mapper.toEntity(dto);

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("test");
        assertThat(user.getEmail()).isEqualTo("test@test");
        assertThat(user.getPhoneNum()).isEqualTo("01011111111");
        assertThat(user.getBirthDt()).isEqualTo(now);
        assertThat(user.getCreateUserId()).isEqualTo("USR0001");
    }
}
