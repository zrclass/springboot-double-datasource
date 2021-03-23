package org.zrclass.doublesource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhourui 20114535
 * @version 1.0
 * @date 2021/3/23 20:44
 */
@SpringBootApplication
@MapperScan("org.zrclass.doublesource.web.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
