package com.shuyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/***
 *
 */
@SpringBootApplication(scanBasePackages = {
        "com.shuyu.**",
})
@EnableSwagger2
@EnableCaching
public class ShuyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShuyuApplication.class, args);
    }

}
