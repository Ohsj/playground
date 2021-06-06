package com.osj4532.playground.mapstruct;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.dto.UserMstDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMstMapper extends ObjectMapper<UserMstDto, UserMst>{
}
