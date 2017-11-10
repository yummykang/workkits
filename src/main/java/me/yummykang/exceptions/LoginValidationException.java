package me.yummykang.exceptions;

import me.yummykang.constant.ErrorCode;

/**
 * 自定义Token验证异常
 *
 * @author demon
 * @since
 */
public class LoginValidationException extends Exception {
	public LoginValidationException(ErrorCode message) {
		super(message.getMessage());
	}
}
