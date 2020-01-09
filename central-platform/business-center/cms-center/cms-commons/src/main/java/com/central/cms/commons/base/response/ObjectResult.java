package com.central.cms.commons.base.response;


import com.central.cms.commons.constant.Enumerations;

public class ObjectResult extends Result {


    public ObjectResult(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public static ObjectResult success(){
        return new ObjectResult(Enumerations.ResultCode.成功.getCode(),Enumerations.ResultCode.成功.name(),null);
    }

    public static ObjectResult success(String message){
        return new ObjectResult(Enumerations.ResultCode.成功.getCode(),message,null);
    }

    public static ObjectResult success(Integer code, String message, Object data){
        return new ObjectResult(code,message,data);
    }


    public static ObjectResult  error(){
        return new ObjectResult(Enumerations.ResultCode.失败.getCode(),Enumerations.ResultCode.成功.name(),null);
    }

    public static ObjectResult error(String message){
        return new ObjectResult(Enumerations.ResultCode.失败.getCode(),message,null);
    }

    public static ObjectResult error(Integer code, String message, Object data){
        return new ObjectResult(code,message,data);
    }
}
