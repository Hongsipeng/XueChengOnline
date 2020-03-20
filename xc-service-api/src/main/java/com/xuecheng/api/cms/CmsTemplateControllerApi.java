package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.stereotype.Service;

/**
 * @author HongSipeng
 * @create 2020-02-28-16:48
 * @description
 */
@Service
@Api(value = "cms模板管理接口", description = "cms模板管理接口，提供站点的增、删、改、查")
public interface CmsTemplateControllerApi {
    @ApiOperation("查询所有模板")
    public QueryResponseResult findTemplate();
}
