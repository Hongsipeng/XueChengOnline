package com.xuecheng.manage_cms.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HongSipeng
 * @create 2020-02-28-16:53
 * @description
 */
@Service
public class TemplateService {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    public QueryResponseResult findTemplate() {
        QueryResult<CmsTemplate> cmsTemplateQueryResult = new QueryResult<>();
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        cmsTemplateQueryResult.setList(all);
        return new QueryResponseResult(CommonCode.SUCCESS, cmsTemplateQueryResult);
    }
}
