package cn.yccoding.oss.service;

import java.io.InputStream;

/**
 * 文件服务类
 *
 * @author YC
 * @since 2020/7/23
 */
public interface FileService {
    /**
     * 文件上传
     * @param inputStream
     * @param module 文件夹名称
     * @param originalFilename
     * @return 图片url地址
     */
    String upload(InputStream inputStream,String module,String originalFilename, String secret);
}
