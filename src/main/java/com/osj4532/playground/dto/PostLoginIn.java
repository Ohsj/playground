package com.osj4532.playground.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 로그인을 위한 DTO
 * 210619 | osj4532 | created
 */

@Getter
@Setter
@AllArgsConstructor
public class PostLoginIn {
    @NotNull(message = "email을 입력해 주세요")
    @Email
    private String email;
    @NotNull(message = "비밀번호를 입력해 주세요")
    private String passwd;
}
