package com.thoughtworks.capacity.gtb.mvc.validator.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UserValidator implements ConstraintValidator<UserValidation, String> {

    private static final String USERNAME_PATTERN = "^[0-9a-zA-Z_]+$";
    private boolean require = false;

    @Override
    public void initialize(UserValidation constraintAnnotation) {
        require = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == "" || value == null) {
            return false;
        }
        if (value.length() < 3 || value.length() > 10) {
            return false;
        }
        if (!Pattern.matches(USERNAME_PATTERN, value)) {
            return false;
        }
        return true;
    }
}
