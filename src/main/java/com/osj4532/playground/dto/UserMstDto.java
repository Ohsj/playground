package com.osj4532.playground.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

/**
 * 210606 | osj4532 | created
 * 210619 | osj4532 | passwd 컬럼 추가
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserMstDto{
    private String userId;
    private String userName;
    private Date birthDt;
    private String email;
    private String passwd;
    private String phoneNum;
    private LocalDateTime createDt;
    private String createUserId;
    private LocalDateTime updateDt;
    private String updateUserId;
}
