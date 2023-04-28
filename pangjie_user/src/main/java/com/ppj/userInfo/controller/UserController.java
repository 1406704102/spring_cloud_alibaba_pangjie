package com.ppj.userInfo.controller;

import com.domain.User;
import com.ppj.userInfo.service.UserService;
import com.result.Result;
import com.result.ResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/findByUsername")
    public Result<User> findByUsername(String username) {
        User userInfo = userService.findByUsername(username);
        return ResultUtil.data(userInfo);
    }


    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable("id") Integer id) {
        return ResultUtil.data(userService.findById(id));
    }
}
