package cn.yccoding.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YC
 * @since 2020/7/14
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"cn.yccoding"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
