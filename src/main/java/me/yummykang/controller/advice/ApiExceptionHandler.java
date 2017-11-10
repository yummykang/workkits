package me.yummykang.controller.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import me.yummykang.bean.Response;
import me.yummykang.constant.ErrorCode;
import me.yummykang.exceptions.BusinessErrorException;
import me.yummykang.exceptions.LoginValidationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-09 11:19.
 */
@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler implements ResponseBodyAdvice<Object> {
    /**
     * Token验证异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(LoginValidationException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Response handleTokenValidationException(LoginValidationException ex) {
        ex.printStackTrace();
        return new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 业务异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Response handleBusinessErrorException(BusinessErrorException ex) {
        ex.printStackTrace();
        return new Response(Integer.parseInt(ex.getCode()), ex.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 参数类型不匹配
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleTypeMismatchException(TypeMismatchException ex) {
        ex.printStackTrace();
        return new Response(HttpStatus.BAD_REQUEST.value(), ErrorCode.TYPE_MISMATCH.getMessage(), null, System.currentTimeMillis());
    }


    /**
     * 运行时异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleUnexpectedServerError(RuntimeException ex) {
        ex.printStackTrace();
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), Throwables.getRootCause(ex).getMessage(), null, System.currentTimeMillis());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Response) {
            return o;
        } else {
            Response response = new Response();
            response.setData(o);
            if (o instanceof String) {
                try {
                    return new ObjectMapper().writeValueAsString(response);
                } catch (JsonProcessingException e) {
                    log.error("jackson解析出错", e);
                }
            }
            return response;
        }
    }
}
