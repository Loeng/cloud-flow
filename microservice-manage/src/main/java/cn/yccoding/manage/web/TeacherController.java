package cn.yccoding.manage.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.yccoding.common.vo.R;
import cn.yccoding.manage.domain.entity.Teacher;
import cn.yccoding.manage.domain.service.TeacherService;
import cn.yccoding.manage.object.TeacherQo;
import reactor.core.publisher.Mono;

/**
 * 教师控制器--反应式编程
 *
 * @author YC
 * @since 2020/7/13
 **/
@CrossOrigin
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    public static void main(String[] args) throws InterruptedException {
        List<Teacher> teachers = new ArrayList<>();
        while (true) {
            teachers.add(new Teacher());
            Thread.sleep(10);
        }
    }

    @GetMapping("/one/{id}")
    public Mono<R> findById(@PathVariable String id) {
        return teacherService.findOne(id).map(i -> R.ok().data("item1", i));
    }

    @GetMapping("/one2/{id}")
    public R findById2(@PathVariable String id) {
        Optional<Teacher> teacher = teacherService.findOne2(id);
        return R.ok().data("item2", teacher);
    }

    @GetMapping("/one3/{id}")
    public CompletableFuture<R> findById3(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Teacher> teacher = teacherService.findOne2(id);
            return R.ok().data("item3", teacher);
        });
    }

    @GetMapping("/list")
    public Mono<R> findAll() {
        TeacherQo teacherQo = new TeacherQo();
        teacherQo.setSize(1);
        teacherQo.setPage(2);
        return teacherService.findAll(teacherQo).collectList().map(i -> R.ok().data("items", i));
    }

    @GetMapping("/list4")
    public Mono<R> findAll4() {
        TeacherQo teacherQo = new TeacherQo();
        teacherQo.setSize(2);
        teacherQo.setPage(1);
        return teacherService.findAll3(teacherQo).collectList().map(i -> R.ok().data("items", i));
    }

    @GetMapping("/list2")
    public R findByAll2() {
        Iterable<Teacher> teacher = teacherService.findAll2();
        return R.ok().data("items2", teacher);
    }

    @GetMapping("/list3")
    public CompletableFuture<R> findAll3() {
        return CompletableFuture.supplyAsync(() -> {
            Iterable<Teacher> teacher = teacherService.findAll2();
            return R.ok().data("items3", teacher);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<R> deleteById(@PathVariable String id) {
        teacherService.deleteById(id);
        return Mono.just(R.ok().message("删除成功"));
    }

    @PostMapping
    public Mono<R> save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher).map(i -> R.ok().data("item", i));
    }

}
