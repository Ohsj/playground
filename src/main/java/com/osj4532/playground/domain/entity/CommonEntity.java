package com.osj4532.playground.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonEntity {
    @CreatedDate
    @Column(name = "create_dt")
    private LocalDateTime createDt;
    @Column(name = "create_user_id")
    private String createUserId;
    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt;
    @Column(name = "update_user_id")
    private String updateUserId;
}
