package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author HongSipeng
 * @create 2020-02-28-16:56
 * @description
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {

}
