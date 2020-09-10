package com.thoughtworks.capacity.gtb.mvc.tool;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:35
 * @Description ***
 **/
public class ConvertTool {
    public static UserEntity convertUserToUserEntity(User user) {
        return UserEntity.builder()
                .userName(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public static User convertUserEntityToUser(UserEntity userEntity) {
        return User.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .build();
    }
}
