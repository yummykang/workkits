package me.yummykang.interceptor;

import me.yummykang.constant.ErrorCode;
import me.yummykang.exceptions.LoginValidationException;
import me.yummykang.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-09 11:17.
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader  = request.getHeader(tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length());
            if (jwtTokenUtil.validateToken(authToken)) {
                return true;
            } else {
                throw new LoginValidationException(ErrorCode.UNAUTHRIZED);
            }
        } else {
            throw new LoginValidationException(ErrorCode.UNAUTHRIZED);
        }
    }


}
