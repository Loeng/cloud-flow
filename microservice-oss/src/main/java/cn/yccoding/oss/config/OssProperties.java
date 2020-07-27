package cn.yccoding.oss.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * oss配置
 *
 * @author YC
 * @since 2020/7/23
 */
@Component
@Data
@ConfigurationProperties(prefix = "ali-yun.oss.file")
public class OssProperties {
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("key-id")
    private String keyId;
    @JsonProperty("key-secret")
    private String keySecret;
    @JsonProperty("bucket-name")
    private String bucketName;
}
