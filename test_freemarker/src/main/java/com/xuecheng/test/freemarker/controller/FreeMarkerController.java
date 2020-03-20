package com.xuecheng.test.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author HongSipeng
 * @create 2020-03-16-15:34
 * @description
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {
    @RequestMapping("/banner")
    public String freeMarker(Map <String,Object> map){
        return "index_banner";
    }
}
