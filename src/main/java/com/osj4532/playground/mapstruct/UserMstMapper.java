package com.osj4532.playground.mapstruct;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.dto.UserMstDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 210606 | osj4532 | created
 * 210619 | osj4532 | mapper 맞지않는 타겟 무시 설정 추가
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMstMapper extends ObjectMapper<UserMstDto, UserMst>{
}
