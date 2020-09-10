package com.thoughtworks.capacity.gtb.mvc.handler;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.Set;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:32
 * @Description ***
 **/
@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserExistException.class)
    public ResponseEntity userExistException(UserExistException userExistException) {
        ErrorResult errorResult = new ErrorResult(userExistException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity userConstraintException(ConstraintViolationException ex) {
        Optional<ConstraintViolation<?>> constrainException = ex.getConstraintViolations()
                .stream().findAny();
        if (constrainException.isPresent()) {
            ErrorResult errorResult = new ErrorResult(constrainException.get().getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorResult);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("no error message");
    }
}
