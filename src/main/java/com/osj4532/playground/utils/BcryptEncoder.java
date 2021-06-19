package com.osj4532.playground.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 210619 | osj4532 | created
 *
 * 비밀번호를 암호화 하기 위해 사용하는 encoder
 */

@Component
public class BcryptEncoder implements PasswordEncoder {
    private final PasswordEncoder passwordEncoder;

    public BcryptEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (!StringUtils.hasText(rawPassword)) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }

        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (!StringUtils.hasText(rawPassword)) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }

        if (!StringUtils.hasText(encodedPassword)) {
            throw new IllegalArgumentException("encodedPassword cannot be null");
        }

        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
