package com.xuecheng.test.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HongSipeng
 * @create 2020-03-16-15:20
 * @description
 */
@SpringBootApplication
//扫描本项目下的所有类
public class FreemarkerTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreemarkerTestApplication.class, args);
    }
}
