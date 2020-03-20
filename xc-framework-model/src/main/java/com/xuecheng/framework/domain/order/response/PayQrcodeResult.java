package com.xuecheng.framework.domain.order.response;

import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/27.
 */
@Data
@ToString
public class PayQrcodeResult extends ResponseResult {
    public PayQrcodeResult(CommonCode commonCode){
        super(commonCode);
    }
    private String codeUrl;
    private Float money;
    private String orderNumber;

}
