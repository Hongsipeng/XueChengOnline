package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.*;

@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    //页面查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("新增页面")
    public CmsPageResult add(CmsPage cmspage);

    @ApiOperation("修改页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "cmsPage", value = "cmsPage对象", required = true, paramType = "params", dataType = "String")
    })
    public ResponseResult editPage(String id, CmsPage cmsPage);

    @ApiOperation("通过id查询页面")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path", dataType = "String")
    public CmsPageResult findById(String id);

    @ApiOperation("通过id删除页面")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path", dataType = "String")
    public ResponseResult delete(String id);
}
