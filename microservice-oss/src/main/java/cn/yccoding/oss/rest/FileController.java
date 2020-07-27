package cn.yccoding.oss.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import cn.hutool.core.io.LineHandler;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import cn.yccoding.common.exception.CustomException;
import cn.yccoding.common.vo.R;
import cn.yccoding.oss.service.FileService;

/**
 * 文件控制器
 *
 * @author YC
 * @since 2020/7/23
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, @RequestParam String module) {
        InputStream is = null;
        try {
            is = file.getInputStream();
        } catch (IOException e) {
            throw new CustomException(50001, "文件读取失败");
        }
        String originalFilename = file.getOriginalFilename();
        String url = fileService.upload(is, module, originalFilename);
        return R.ok().data("url", url).message("文件上传成功");
    }
}
