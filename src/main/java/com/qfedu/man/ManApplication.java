package com.qfedu.man;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication //主配置类
@ServletComponentScan //扫秒过滤器
@MapperScan("com.qfedu.man.dao") //扫秒dao层
public class ManApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(ManApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(ManApplication.class, args);
    }

}
