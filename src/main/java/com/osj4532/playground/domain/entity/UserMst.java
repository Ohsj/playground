package com.osj4532.playground.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_mst")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class UserMst extends CommonEntity implements Serializable {
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
