package cn.yccoding.edu.web;

import cn.yccoding.common.vo.R;
import cn.yccoding.edu.domain.entity.Teacher;
import cn.yccoding.edu.domain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

/**
 * 教师控制器--反应式编程
 *
 * @author YC
 * @since 2020/7/13
 **/
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    public Flux<R> findById(@PathVariable String id) {
        Teacher teacher = teacherService.findOne(id);
        return Flux.just(R.ok().data("item", teacher));
    }
}
