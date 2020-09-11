package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:30
 * @Description ***
 **/
@RestController
@Validated
public class UserController {

    private static final String USERNAME_PATTERN = "^[0-9a-zA-Z_]+$";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User user)
            throws UserException {
        Integer userId = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("userId", userId.toString())
                .build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam(value = "username")
                                      @NotBlank(message = ErrorMessage.USER_NOT_NULL)
                                      @Pattern(regexp = USERNAME_PATTERN, message = ErrorMessage.USER_INVALID)
                                      @Size(min = 3, max = 10, message = ErrorMessage.USER_INVALID)
                                              String username,
                                      @RequestParam(value = "password")
                                      @NotBlank(message = ErrorMessage.PASSWORD_NOT_NULL)
                                      @Size(min = 5, max = 12, message = ErrorMessage.PASSWORD_INVALID)
                                              String password) throws UserException {
        User user = userService.validateUserNameAndPassword(username, password);
        return ResponseEntity.ok(user);
    }
}
