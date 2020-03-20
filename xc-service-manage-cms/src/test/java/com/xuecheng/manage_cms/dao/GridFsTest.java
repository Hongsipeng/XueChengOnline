package com.xuecheng.manage_cms.dao;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author HongSipeng
 * @create 2020-03-16-13:37
 * @description
 */
@SpringBootTest
public class GridFsTest {
    @Autowired
    GridFsTemplate gridFsTemplate;

    @Test
    public void testStore() throws FileNotFoundException {
        File file = new File("E:/IdeaProjects/xuecheng/xc-ui-pc-static-portal/include/index_banner.html");
        FileInputStream inputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(inputStream,"轮播图测试","");
        String toString = objectId.toString();
        System.out.println(toString);


    }
}

