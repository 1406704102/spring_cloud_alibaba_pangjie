package org.pangjie.login.controller;


import com.domain.User;
import com.exception.PJException;
import com.result.Result;
import com.result.ResultCode;
import com.result.ResultUtil;
import feign.userInfo.client.UserServiceFeign;
import lombok.AllArgsConstructor;
import org.pangjie.login.service.AuthService;
import org.pangjie.login.service.impl.AuthServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public Result<User> signUp(@Valid @RequestBody User user) throws PJException {
        user.setUsername(user.getUsername());
        throw new PJException(ResultCode.MODEL_NOT_EXIST);
//        int i = 1 / 0;
//        User user1 = authService.signUp(user);
//        return ResultUtil.data(user1);
    }

    @PostMapping("/signIn")
    public Result<User> signIn(@Valid @RequestBody User user) {
        user.setUsername(user.getUsername());
        User user1 = authService.signUp(user);
        return ResultUtil.data(user1);
    }
}
