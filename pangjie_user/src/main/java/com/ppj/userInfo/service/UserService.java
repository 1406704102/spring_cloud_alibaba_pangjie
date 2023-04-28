package com.ppj.userInfo.service;

import com.domain.User;

public interface UserService {
    User findById(Integer id);

    User create(User user);

    User findByUsername(String username);
}
