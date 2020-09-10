package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:30
 * @Description ***
 **/
@RestController
public class UserController {

    @PostMapping("/register")
    public void register(User user) {

    }
}
