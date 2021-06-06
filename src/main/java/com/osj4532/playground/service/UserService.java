package com.osj4532.playground.service;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.domain.repo.UserRepo;
import com.osj4532.playground.dto.UserMstDto;
import com.osj4532.playground.mapstruct.UserMstMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 210606 | osj4532 | create
 */

@Service
public class UserService extends BaseService {

    private final UserMstMapper userMapper = Mappers.getMapper(UserMstMapper.class);
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * 유저 아이디로 유저 정보 단건 조회
     * @param userId 유저 아이디
     * @return UserMstDto 유저 entity를 유저 dto로 변환한값
     */
    public UserMstDto getUserOne(String userId) {
        Optional<UserMst> user = userRepo.findById(userId);
        if (!user.isPresent()) {
            throw new NoSuchElementException();
        }

        return userMapper.toDto(user.get());
    }
}
