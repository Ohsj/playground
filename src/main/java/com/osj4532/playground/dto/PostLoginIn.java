package com.osj4532.playground.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 로그인을 위한 DTO
 * 210619 | osj4532 | created
 */

@Getter
@Setter
@AllArgsConstructor
public class PostLoginIn {
    private String email;
    private String passwd;
}
