package com.thoughtworks.capacity.gtb.mvc.domain;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:34
 * @Description ***
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    @Length(min = 3, max = 10, message = ErrorMessage.USER_INVALID)
    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = ErrorMessage.USER_INVALID)
    @NotNull(message = ErrorMessage.USER_NOT_NULL)
    private String userName;

    @NotNull(message = ErrorMessage.PASSWORD_NOT_NULL)
    @Length(min = 5, max = 12, message = ErrorMessage.PASSWORD_INVALID)
    private String password;

    @Email(message = ErrorMessage.EMAIL_INVALID)
    private String email;
}
