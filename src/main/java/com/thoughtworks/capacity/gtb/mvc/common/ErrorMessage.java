package com.thoughtworks.capacity.gtb.mvc.common;

public class ErrorMessage {
    public static final String USER_INVALID = "用户名不合法";
    public static final String USER_NOT_NULL = "用户名不能为空";
    public static final String PASSWORD_NOT_NULL = "密码不能为空";
    public static final String PASSWORD_INVALID = "密码不合法";
    public static final String EMAIL_INVALID = "邮箱地址不合法";
    public static final String USER_EXIST = "用户已存在";

    public static final Integer REQUEST_ERROR_CODE = 400;
//    public enum ErrorsEnum {
//
//        USER_EXIST(400, "用户已存在");
//
//        ErrorsEnum(Integer code, String message) {
//            this.code = code;
//            this.message = message;
//        }
//
//        private final Integer code;
//        private final String message;
//
//        public Integer getCode() {
//            return code;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//    }
}

