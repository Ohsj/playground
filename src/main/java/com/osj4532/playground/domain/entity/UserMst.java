package com.osj4532.playground.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_mst")
@Getter
@Setter
@ToString(callSuper = true)
public class UserMst extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", length = 7)
    private String userId;
    @Column(name = "user_name", nullable = false, length = 10)
    private String userName;
    @Column(name = "birth_dt", nullable = false)
    private Date birthDt;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_num", nullable = false, length = 11)
    private String phoneNum;
}
