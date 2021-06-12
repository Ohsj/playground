package com.osj4532.playground.controller;

import ch.qos.logback.classic.Logger;
import com.osj4532.playground.error.ExceptionResponse;
import com.osj4532.playground.error.ForbiddenException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 210417 | osj4532 | created
 * 210612 | osj4532 | exception handler add
 */

public abstract class BaseController {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    /**
     * 모든 예외를 처리할 핸들러
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest req, Exception e) {
        LocalDateTime now = LocalDateTime.now();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (e instanceof ForbiddenException) {
            status = HttpStatus.FORBIDDEN;
        }

        ExceptionResponse res = new ExceptionResponse();
        res.setStatus(status.toString());
        res.setStatusName(status.name());
        res.setErrClassName(e.getClass().getSimpleName());
        res.setErrMsg(e.getMessage());
        res.setPath(req.getRequestURI());
        res.setTimestamp(now.toString());


        return ResponseEntity.status(status).body(res);
    }
}
