package cn.yccoding.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YC
 * @since 2020/7/14
 * 该项目不实用mysql，取消依赖传递，排除数据源自动配置
 **/
@ComponentScan(basePackages = {"cn.yccoding"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
