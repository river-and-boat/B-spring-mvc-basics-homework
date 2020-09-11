package com.thoughtworks.capacity.gtb.mvc.domain;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

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

    @Size(min = 3, max = 10, message = ErrorMessage.USER_INVALID)
    @NotBlank(message = ErrorMessage.USER_NOT_NULL)
    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = ErrorMessage.USER_INVALID)
    private String username;

    @NotBlank(message = ErrorMessage.PASSWORD_NOT_NULL)
    @Size(min = 5, max = 12, message = ErrorMessage.PASSWORD_INVALID)
    private String password;

    @Email(message = ErrorMessage.EMAIL_INVALID)
    @Builder.Default
    private String email = "";
}
