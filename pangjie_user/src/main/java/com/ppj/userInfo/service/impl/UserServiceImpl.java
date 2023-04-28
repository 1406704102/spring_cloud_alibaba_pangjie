package com.ppj.userInfo.service.impl;

import com.domain.User;
import com.ppj.userInfo.repo.UserRepo;
import com.ppj.userInfo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public User findById(Integer id) {
        User user = userRepo.findById(id).orElseGet(User::new);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        User byUsername = userRepo.findByUsername(user.getUsername());
        if (byUsername != null) {
            throw new RuntimeException("用户名相同");
        }
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User byUsername = userRepo.findByUsername(username);
        return byUsername;
    }
}
