package com.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * jar
 * @author
 * @date 2020/03/21 15:46
 **/
@SpringBootApplication
public class SpingBootApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpingBootApplication.class, args);
        logger.info("-----------------项目启动完成");
    }

}
