package com.thoughtworks.capacity.gtb.mvc.handler;

import com.thoughtworks.capacity.gtb.mvc.common.ErrorMessage;
import com.thoughtworks.capacity.gtb.mvc.common.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 7:32
 * @Description ***
 **/
@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity userExistException(UserException userException) {
        ErrorResult errorResult = new ErrorResult(ErrorMessage.REQUEST_ERROR_CODE,
                userException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity userConstraintException(ConstraintViolationException ex) {
        Optional<ConstraintViolation<?>> constrainException = ex.getConstraintViolations()
                .stream().findFirst();
        if (constrainException.isPresent()) {
            ErrorResult errorResult = new ErrorResult(ErrorMessage.REQUEST_ERROR_CODE,
                    constrainException.get().getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorResult);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("no error message");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(ErrorMessage.REQUEST_ERROR_CODE, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResult> requestParameterException(MissingServletRequestParameterException ex) {
        String parameterName = ex.getParameterName();
        String message = parameterName + "是必填项";
        ErrorResult errorResult = new ErrorResult(ErrorMessage.REQUEST_ERROR_CODE, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
