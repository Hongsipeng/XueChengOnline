package com.xuecheng.manage_cms.web;

import com.xuecheng.api.cms.CmsSiteControllerApi;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HongSipeng
 * @create 2020-02-27-16:43
 * @description
 */
@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {
    @Autowired
    SiteService siteService;
    @Override
    @GetMapping("/list")
    public QueryResponseResult findSiteList() {
        return siteService.findSiteList();
    }
}
