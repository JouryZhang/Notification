package com.home.security.utils;//package com.pyq.utils;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.io.Serializable;
/**
 * @Description 封装返回数据结构体
 * @author
 * @date 2019/12/19 15:25
 **/
public class ResponseResult<T> implements Serializable {

    private static final String OK = "0000";
    private static final String ERR = "9999";

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T data;

    public ResponseResult() {
        this(OK, "OK", null);
    }

    public ResponseResult(T data) {
        this(OK, "OK", data);
    }

    public ResponseResult(String code, String message) {
        this(code, message, null);
    }

    public ResponseResult(String code, T data) {
        this(code, "", data);
    }

    public ResponseResult(String code, String message, @Nullable T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(HttpStatus status) {
        this(String.valueOf(status.value()), status.getReasonPhrase(), null);
    }

    public ResponseResult(HttpStatus status, String message) {
        this(String.valueOf(status.value()), message, null);
    }

    public ResponseResult(HttpStatus status, T data) {
        this(String.valueOf(status.value()), status.getReasonPhrase(), data);
    }

    public ResponseResult(HttpStatus status, String message, T data) {
        this.code = String.valueOf(status.value());
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok() {
        return new ResponseResult<>();
    }

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<>(data);
    }

    public static <T> ResponseResult<T> ok(String message, T data) {
		return new ResponseResult<>(OK, message, data);
    }

    public static ResponseResult err() {
        return new ResponseResult<>(ERR, "错误");
    }

    public static <T> ResponseResult<T> err(String message) {
        return new ResponseResult<>(ERR, message);
    }

    public static <T> ResponseResult<T> err(String message, T data) {
        return new ResponseResult<>(ERR, message, data);
    }

    public static <T> ResponseResult<T> err(T data) {
        return new ResponseResult<>(ERR, data);
    }

    public static <T> ResponseResult<T> err(String code, String message, T data) { return new ResponseResult<>(code,message,data); }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {return OK.equals(code);}

    public static String success(){
        return OK;
    }
    public static String failure(){ return ERR; }
    public static <T> ResponseResult<T> failure(String code, String message, T data) { return new ResponseResult<>(code,message,data); }

}
