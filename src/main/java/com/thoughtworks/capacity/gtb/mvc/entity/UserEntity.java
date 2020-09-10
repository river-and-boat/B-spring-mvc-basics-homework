package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:33
 * @Description ***
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private String userName;
    private String password;
    private String email;
}
