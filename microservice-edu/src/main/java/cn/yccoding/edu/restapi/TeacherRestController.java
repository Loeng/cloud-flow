package cn.yccoding.edu.restapi;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yccoding.common.vo.R;
import cn.yccoding.edu.domain.entity.Teacher;
import cn.yccoding.edu.domain.service.TeacherService;

/**
 * 教师控制器--非阻塞式异步编程
 *
 * @author YC
 * @since 2020/7/11
 **/
@RestController
@RequestMapping("/api/v2/teachers")
public class TeacherRestController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    public CompletableFuture<R> findById(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> {
            Teacher teacher = teacherService.findOne(id);
            return R.ok().data("item", teacher);
        });
    }
}
