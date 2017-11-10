package me.yummykang.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.yummykang.constant.ErrorCode;

/**
 * 业务异常错误
 *
 * @author demon
 */
@Data
@NoArgsConstructor
public class BusinessErrorException extends Exception {
    /**
     * 异常code
     */
    private String code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 异常信息的参数
     */
    private String params;

    public BusinessErrorException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public BusinessErrorException(ErrorCode errorCode, String params) {
        this.code = errorCode.getCode();
        this.message = String.format(errorCode.getMessage(), params);
    }
}
