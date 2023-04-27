package com.ppj.userInfo.service.impl;

import com.domain.User;
import com.ppj.userInfo.repo.UserRepo;
import com.ppj.userInfo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public User findById(Integer id) {
        User user = userRepo.findById(id).orElseGet(User::new);
        return user;
    }
}
