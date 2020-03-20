package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author HongSipeng
 * @create 2020-03-03-10:07
 * @description 自定义异常类
 */
public class CustomException extends RuntimeException {
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        super("错误代码：" + resultCode.code() + "错误信息：" + resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
