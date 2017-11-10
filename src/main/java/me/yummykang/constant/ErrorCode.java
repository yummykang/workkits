package me.yummykang.constant;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-06-15 15:45.
 */
public enum ErrorCode {
    TYPE_MISMATCH("1000", "参数错误"),
    INTERNAL_ERROR("1001", "系统异常"),
    UNAUTHRIZED("1002", "认证失败，请重新登录"),
    NAME_OR_PWD_ERROR("1003", "用户名或者密码错误");

    private String code;

    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
