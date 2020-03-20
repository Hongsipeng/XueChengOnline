package com.xuecheng.manage_cms.web;

import com.xuecheng.api.cms.CmsTemplateControllerApi;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HongSipeng
 * @create 2020-02-28-16:52
 * @description
 */
@RestController
@RequestMapping("/cms/template")
public class CmsTemplateConteoller implements CmsTemplateControllerApi {
    @Autowired
    TemplateService templateService;
    @Override
    @GetMapping("/list")
    public QueryResponseResult findTemplate() {
        return templateService.findTemplate();
    }
}
