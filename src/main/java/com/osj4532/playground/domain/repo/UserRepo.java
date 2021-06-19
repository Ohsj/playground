package com.osj4532.playground.domain.repo;

import com.osj4532.playground.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 210523 | osj4532 | created
 * 210619 | osj4532 | findByEmail add
 */

public interface UserRepo extends JpaRepository<UserMst, String> {
    Optional<UserMst> findByEmail(String email);
}
