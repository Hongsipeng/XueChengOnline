package com.xuecheng.manage_cms.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import com.xuecheng.manage_cms.web.CmsSiteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HongSipeng
 * @create 2020-02-27-16:44
 * @description
 */
@Service
public class SiteService {
    @Autowired
    CmsSiteRepository cmsSiteRepository;
    public QueryResponseResult findSiteList() {
        List<CmsSite> siteList = cmsSiteRepository.findAll();
        QueryResult<CmsSite> queryResult= new QueryResult<CmsSite>();
        queryResult.setList(siteList);
        QueryResponseResult queryResponseResult= new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
