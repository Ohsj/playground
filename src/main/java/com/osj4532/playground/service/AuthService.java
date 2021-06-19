package com.osj4532.playground.service;

import com.osj4532.playground.dto.PostLoginIn;
import com.osj4532.playground.dto.UserMstDto;
import com.osj4532.playground.error.UnauthorizedException;
import com.osj4532.playground.utils.BcryptEncoder;
import com.osj4532.playground.utils.JwtProvider;
import org.springframework.stereotype.Service;

/**
 * 210619 | osj4532 | created
 */

@Service
public class AuthService extends BaseService{

    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final BcryptEncoder bcryptEncoder;

    public AuthService(UserService userService, JwtProvider jwtProvider, BcryptEncoder bcryptEncoder) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.bcryptEncoder = bcryptEncoder;
    }

    /**
     * 이메일과 비밀번호가 넘어오면 이메일과 비밀번호가 일치하는지 보고 JWT를 반환해준다.
     * @param input 이메일과 비밀번호로 이루어진 input
     * @return token
     */
    public String login(PostLoginIn input) {
        UserMstDto user = userService.getUserOneByEmail(input.getEmail());
        if (!bcryptEncoder.matches(input.getPasswd(), user.getPasswd())) {
            throw new UnauthorizedException("Not Match Email and Password!");
        }
        return jwtProvider.createToken(user);
    }
}
