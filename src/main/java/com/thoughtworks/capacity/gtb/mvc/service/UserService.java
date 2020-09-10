package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import com.thoughtworks.capacity.gtb.mvc.tool.ConvertTool;
import org.springframework.stereotype.Service;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:31
 * @Description ***
 **/
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer registerUser(User user) throws UserExistException {
        UserEntity userEntity = ConvertTool.convertUserToUserEntity(user);
        UserEntity savedUser = userRepository.saveUserEntity(userEntity);
        return savedUser.getId();
    }
}
