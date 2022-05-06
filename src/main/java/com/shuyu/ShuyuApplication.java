package com.shuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * 描述：简历框架模板
 * @author 郑鹏川
 * @date 2021年4月6日
 */
@SpringBootApplication(scanBasePackages = {
        "com.zpc.**",
})
@EnableSwagger2
@EnableCaching
public class ShuyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
