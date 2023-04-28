package org.pangjie.login.controller;


import com.domain.User;
import com.result.Result;
import com.result.ResultUtil;
import feign.userInfo.client.UserServiceFeign;
import lombok.AllArgsConstructor;
import org.pangjie.login.service.AuthService;
import org.pangjie.login.service.impl.AuthServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/sigUp")
    public Result<User> signUp(String username) {
        User user = new User();
        user.setUsername(username);
        User user1 = authService.signUp(user);
        return ResultUtil.data(user);
    }
}
