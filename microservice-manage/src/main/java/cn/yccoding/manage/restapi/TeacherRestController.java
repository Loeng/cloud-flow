package cn.yccoding.manage.restapi;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.yccoding.common.vo.R;
import cn.yccoding.manage.domain.entity.Teacher;
import cn.yccoding.manage.domain.service.TeacherService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/list")
    public CompletableFuture<R> getList() {
        return CompletableFuture.supplyAsync(()->{
            Flux<Teacher> all = teacherService.findAll(null);
            return R.ok().data("items", all);
        });
    }

    @GetMapping("/{id}")
    public CompletableFuture<R> findById(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> {
            Mono<Optional<Teacher>> one = teacherService.findOne(id);
            return R.ok().data("item", one);
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<R> deleteById(@PathVariable String id) {
        return CompletableFuture.supplyAsync(()->{
            teacherService.deleteById(id);
            return R.ok().message("删除成功");
        });
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
