package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author HongSipeng
 * @create 2020-03-03-10:40
 * @description 自定义异常抛出类
 */
public class ExceptionCast {
    //使用此静态方法抛出异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
