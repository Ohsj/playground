package com.osj4532.playground.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserMstDto {
    private String userId;
    private String userName;
    private Date birthDt;
    private String email;
    private String phoneNum;
    private LocalDateTime createDt;
    private String createUserId;
    private LocalDateTime updateDt;
    private String updateUserId;
}
