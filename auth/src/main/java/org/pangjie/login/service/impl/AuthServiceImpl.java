package org.pangjie.login.service.impl;

import com.domain.User;
import feign.userInfo.client.UserServiceFeign;
import lombok.AllArgsConstructor;
import org.pangjie.login.service.AuthService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceFeign userServiceFeign;

    @Override
    public User signUp(User user) {
        User data = userServiceFeign.findByUsername(user.getUsername()).getData();
        if (data != null) {

        }
        System.out.println(data);
        return data;
    }
}
