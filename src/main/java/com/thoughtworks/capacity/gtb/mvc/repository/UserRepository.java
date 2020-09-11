package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.exception.UserException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:32
 * @Description ***
 **/
@Repository
public class UserRepository {

    private static List<UserEntity> userEntities;

    static {
        userEntities = new ArrayList<>();
    }

    public UserEntity saveUserEntity(UserEntity userEntity) throws UserException {
        userEntity.setId(generateId());
        Optional<UserEntity> existUser = findUserByName(userEntity.getUserName());
        if (existUser.isPresent()) {
            throw new UserException(ErrorMessage.USER_EXIST);
        }
        userEntities.add(userEntity);
        return userEntity;
    }

    public UserEntity getUserByName(String username) throws UserException {
        Optional<UserEntity> userEntity = findUserByName(username);
        if (!userEntity.isPresent()) {
            throw new UserException("用户名或密码错误");
        }
        return userEntity.get();
    }

    private Optional<UserEntity> findUserByName(String username) {
        return userEntities.stream().filter(user ->
                user.getUserName().equals(username))
                .findFirst();
    }

    private synchronized Integer generateId() {
        Integer currentUserCount = userEntities.size();
        return ++currentUserCount;
    }
}
