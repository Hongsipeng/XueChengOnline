package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:32
 **/
@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;
    @Autowired
    CmsConfigRepository cmsConfigRepository;
    @Autowired
    RestTemplate restTemplate;


    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始记数
     * @param size             每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        CmsPage cmsPage = new CmsPage();
        //创建匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains())//别名模糊查询
                .withMatcher("pageName", ExampleMatcher.GenericPropertyMatchers.contains());//名称模糊查询
        if (StringUtils.isNoneEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        if (StringUtils.isNoneEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if (StringUtils.isNoneEmpty(queryPageRequest.getPageId())) {
            cmsPage.setPageId(queryPageRequest.getPageId());
        }
        if (StringUtils.isNoneEmpty(queryPageRequest.getPageName())) {
            cmsPage.setPageName(queryPageRequest.getPageName());
        }
        if (StringUtils.isNoneEmpty(queryPageRequest.getTemplateId())) {
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        if (StringUtils.isNoneEmpty(queryPageRequest.getPageType())) {
            cmsPage.setPageType(queryPageRequest.getPageType());
        }
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 页面添加方法
     *
     * @param cmsPage
     * @return
     */
    public CmsPageResult add(CmsPage cmsPage) {
        //先校验页面是否存在
        CmsPage byPageNameAndPageAliaseAndSiteId = cmsPageRepository.findByPageNameAndPageAliaseAndSiteId(cmsPage.getPageName(), cmsPage.getPageAliase(), cmsPage.getSiteId());
        if (byPageNameAndPageAliaseAndSiteId != null) {//不为空则表示已经存在
//            return new CmsPageResult(CommonCode.FAIL, null);
            //校验页面是否已经存在
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        CmsPage save = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, save);
    }

    /**
     * 通过id查找页面
     *
     * @param id
     * @return
     */
    public CmsPage findById(String id) {
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;

        }
    }

    /**
     * 修改页面
     *
     * @param id
     * @param cmsPage
     * @return
     */
    public ResponseResult editPage(String id, CmsPage cmsPage) {
        CmsPage byId = this.findById(id);
        if (byId != null) {
            byId.setTemplateId(cmsPage.getTemplateId());
            byId.setPageName(cmsPage.getPageName());
            byId.setSiteId(cmsPage.getSiteId());
            byId.setPageAliase(cmsPage.getPageAliase());
            byId.setDataUrl(cmsPage.getDataUrl());
            byId.setPageWebPath(cmsPage.getPageWebPath());
            byId.setPageCreateTime(cmsPage.getPageCreateTime());
            byId.setPageType(cmsPage.getPageType());
            byId.setPageAliase(cmsPage.getPageAliase());
            CmsPage save = cmsPageRepository.save(byId);
            if (save != null) {
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                return new ResponseResult(CommonCode.FAIL);
            }
        } else {
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    /**
     * 通过id删除页面
     *
     * @param id
     * @return
     */
    public ResponseResult deleteById(String id) {
        if (this.findById(id) != null) {
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    /**
     * 根据id查询页面信息
     * @param id
     * @return
     */
    public CmsConfig getConfigById(String id){
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
