package com.osj4532.playground.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 210612 | osj4532 | created
 *
 * 토큰이 없을 경우 사용된다.
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String msg) {
        super(msg);
    }
}