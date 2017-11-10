package me.yummykang.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-09 11:20.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    /**
     * 接口处理状态码
     */
    private int resultCode = 200;
    /**
     * 返回信息
     */
    private String resultMessage = "OK";

    /**
     * 返回json数据
     */
    private Object data;

    /**
     * 系统时间
     */
    private long systemTime = System.currentTimeMillis();
}
