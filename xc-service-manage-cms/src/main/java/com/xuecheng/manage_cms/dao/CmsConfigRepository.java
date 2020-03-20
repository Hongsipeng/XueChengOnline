package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author HongSipeng
 * @create 2020-03-16-10:40
 * @description
 */
public interface CmsConfigRepository  extends MongoRepository<CmsConfig,String> {

}
