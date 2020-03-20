package com.xuecheng.manage_cms.web;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 17:24
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {

        //暂时用静态数据
        //定义queryResult
//        QueryResult<CmsPage> queryResult =new QueryResult<>();
//        List<CmsPage> list = new ArrayList<>();
//        CmsPage cmsPage = new CmsPage();
//        cmsPage.setPageName("测试页面");
//        list.add(cmsPage);
//        queryResult.setList(list);
//        queryResult.setTotal(1);
//
//        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
//        return queryResponseResult;
        //调用service
        return pageService.findList(page, size, queryPageRequest);

    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmspage) {//@RequestBody注解将前端提交过来的json数据转成对象
        return pageService.add(cmspage);
    }

    @Override
    @PutMapping("/edit/{id}")
    public ResponseResult editPage(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
      return pageService.editPage(id, cmsPage);
    }

    @Override
    @GetMapping("/findById/{id}")
    public CmsPageResult findById(@PathVariable("id") String id) {
        CmsPage byId = pageService.findById(id);
        if (byId!=null){
            return new CmsPageResult(CommonCode.SUCCESS,byId);
        }
        return new CmsPageResult(CommonCode.FAIL,null);
    }

    @Override
    @GetMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        return pageService.deleteById(id);
    }


}
