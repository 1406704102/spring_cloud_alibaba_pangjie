package com.ppj.userInfo.controller;

import com.domain.User;
import com.ppj.userInfo.service.UserService;
import com.result.Result;
import com.result.ResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable("id") Integer id) {
        return ResultUtil.success(userService.findById(id));
    }
}
