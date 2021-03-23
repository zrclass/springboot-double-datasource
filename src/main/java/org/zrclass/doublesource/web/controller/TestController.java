package org.zrclass.doublesource.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zrclass.doublesource.web.dao.mysql1.Mysql1Dao;
import org.zrclass.doublesource.web.dao.mysql2.Mysql2Dao;

/**
 * @author zhourui 20114535
 * @version 1.0
 * @date 2021/3/23 21:05
 */
@RestController
public class TestController {

    @Autowired
    private Mysql1Dao mysql1Dao;
    @Autowired
    private Mysql2Dao mysql2Dao;

    @RequestMapping("/test")
    public void test() {
        System.out.println(mysql1Dao.getName());
        System.out.println("===========================================================");
        System.out.println(mysql2Dao.getName());
    }
}
