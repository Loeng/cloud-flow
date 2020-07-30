package cn.yccoding.oss.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import cn.yccoding.common.exception.CustomException;
import cn.yccoding.oss.config.OssProperties;
import cn.yccoding.oss.service.FileService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author YC
 * @since 2020/7/23
 */
@Service
public class FileServiceImpl implements FileService {

    private static final String defaultSecret = "xiaohaimian1234";

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String originalFilename,String secret) {
        if (!defaultSecret.equals(secret)) {
            throw new CustomException(50004, "无效的密钥");
        }

        String endpoint = ossProperties.getEndpoint();
        String accessKeyId = ossProperties.getKeyId();
        String accessKeySecret = ossProperties.getKeySecret();
        String bucketName = ossProperties.getBucketName();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 是否存在
        if (!ossClient.doesBucketExist(bucketName)) {
            ossClient.createBucket(bucketName);
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        }

        // 构建上传文件目录 /2020/04/25/aa.jpg
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate nowDate = LocalDate.now(ZoneOffset.ofHours(8));
        String folder = pattern.format(nowDate);
        // 文件名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String prefixName = UUID.randomUUID().toString().replace("-", "");
        String newFilename = prefixName+suffixName;
        // 文件路径
        String key = String.format("%s/%s/%s", module, folder, newFilename);

        // 上传文件流。
        ossClient.putObject(bucketName, key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        // 返回文件url
        // http://evernote-yc-01.oss-cn-shenzhen.aliyuncs.com/img/001.png
        return String.format("https://%s.%s/%s",bucketName,endpoint,key);
    }
}
