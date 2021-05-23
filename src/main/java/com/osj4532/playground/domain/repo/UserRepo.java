package com.osj4532.playground.domain.repo;

import com.osj4532.playground.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserMst, String> {
}
