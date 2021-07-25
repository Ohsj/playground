package com.osj4532.playground.service;

import com.osj4532.playground.domain.entity.UserMst;
import com.osj4532.playground.domain.repo.UserRepo;
import com.osj4532.playground.dto.PostLoginIn;
import com.osj4532.playground.dto.UserMstDto;
import com.osj4532.playground.mapstruct.UserMstMapper;
import com.osj4532.playground.utils.JwtTokenProvider;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 210606 | osj4532 | create
 */

@Service
public class UserService extends BaseService {

    private final UserMstMapper userMapper = Mappers.getMapper(UserMstMapper.class);
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public UserService(JwtTokenProvider jwtTokenProvider,
                       PasswordEncoder passwordEncoder,
                       UserRepo userRepo) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    /**
     * 유저 아이디로 유저 정보 단건 조회
     * @param userId 유저 아이디
     * @return UserMstDto 유저 entity를 유저 dto로 변환한값
     */
    public UserMstDto getUserOneById(String userId) {
        Optional<UserMst> user = userRepo.findById(userId);
        if (!user.isPresent()) {
            throw new NoSuchElementException("Not exist userId");
        }

        return userMapper.toDto(user.get());
    }

    /**
     * 유저 이메일로 유저 정보 단건 조회
     * @param email 유저 이메일
     * @return UserMstDto 유저 entity를 유저 dto로 변환한값
     */
    public UserMstDto getUserOneByEmail(String email) {
        Optional<UserMst> user = userRepo.findByEmail(email);
        if (!user.isPresent()) {
            throw new NoSuchElementException("Not exist email");
        }
        return userMapper.toDto(user.get());
    }

    /**
     * 로그인 시 정보가 정확하면 token 발급
     * @return String jwtToken
     */
    public String login(PostLoginIn input) {
        UserMstDto user = getUserOneByEmail(input.getEmail());
        if (!passwordEncoder.matches(input.getPasswd(), user.getPasswd())) {
            throw new IllegalArgumentException("wrong password");
        }
        return jwtTokenProvider.createToken(user.getUserId());
    }
}
