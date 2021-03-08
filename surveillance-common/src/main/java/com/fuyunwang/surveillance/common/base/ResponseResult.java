package com.fuyunwang.surveillance.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
public class ResponseResult<T> implements Serializable {
    @JsonProperty(value = "code")
    private int status;
    private String message;
    @JsonProperty(value = "result")
    private T data;

    private ResponseResult(int status) {
        this.status=status;
    }
    private ResponseResult(int status, String message) {
        this.status=status;
        this.message=message;
    }
    private ResponseResult(int status, String message, T data) {
        this.status=status;
        this.message=message;
        this.data=data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ResponseResult<T> createBySuccess(){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseResult<T> createBySuccess(T data){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
    }

    public static <T> ResponseResult<T> createBySuccess(String msg){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseResult<T> createBySuccess(String msg, T data){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ResponseResult<T> createBySuccess(int code, String message, T data){
        return new ResponseResult<T>(code, message, data);
    }

    public static <T> ResponseResult<T> createByError(){
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ResponseResult<T> createByError(String errorMessage){
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResponseResult<T> createByError(int errorCode, String errorMessage){
        return new ResponseResult<T>(errorCode,errorMessage);
    }
    public static <T> ResponseResult<T> createByError(String errorMessage, T data){
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(),errorMessage,data);
    }
    public static <T> ResponseResult<T> createByError(int errorCode, String errorMessage, T data){
        return new ResponseResult<T>(errorCode,errorMessage,data);
    }
}
