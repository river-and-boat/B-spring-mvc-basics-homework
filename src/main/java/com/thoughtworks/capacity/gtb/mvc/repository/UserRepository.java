package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
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

    public UserEntity saveUserEntity(UserEntity userEntity) throws UserExistException {
        userEntity.setId(generateId());
        Optional<UserEntity> existUser = userEntities.stream().filter(user ->
                user.getUserName().equals(userEntity.getUserName()))
                .findAny();
        if (existUser.isPresent()) {
            throw new UserExistException(ErrorMessage.USER_EXIST);
        }
        userEntities.add(userEntity);
        return userEntity;
    }

    private synchronized Integer generateId() {
        Integer currentUserCount = userEntities.size();
        return ++currentUserCount;
    }
}
