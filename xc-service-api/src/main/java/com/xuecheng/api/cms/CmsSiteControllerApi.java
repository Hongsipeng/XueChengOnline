package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

/**
 * @author HongSipeng
 * @create 2020-02-27-16:31
 * @description
 */
@Service
@Api(value="cms站点管理接口",description = "cms站点管理接口，提供站点的增、删、改、查")

public interface CmsSiteControllerApi {
    @ApiOperation("查询所有站点")
    public  QueryResponseResult findSiteList();
}
