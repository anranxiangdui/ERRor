package com.xy.kfmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 配置mapper扫描(如果在每个mapper接口加上@Mapper注解,这个可以省略)
// @MapperScan("com.xy.kfmb.dao")
@SpringBootApplication
public class KfmbApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfmbApplication.class, args);
    }
}
