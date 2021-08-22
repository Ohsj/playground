//package com.osj4532.playground.service;
//
//import com.osj4532.playground.domain.entity.UserMst;
//import com.osj4532.playground.domain.repo.UserRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
///**
// * 210725 | osj4532 | created
// */
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepo userRepo;
//
//    public CustomUserDetailsService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        Optional<UserMst> user = userRepo.findById(userId);
//        if (!user.isPresent()) {
//            throw new NoSuchElementException("Not exist User");
//        }
//        return user.get();
//    }
//}
