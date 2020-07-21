package cn.yccoding.manage.domain.service;

import java.util.Comparator;
import java.util.Optional;

import cn.yccoding.manage.object.TeacherQo;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yccoding.manage.domain.entity.Teacher;
import cn.yccoding.manage.domain.repository.TeacherRepository;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 教师服务类
 *
 * @author YC
 * @since 2020/7/12
 **/
@Service
@Transactional
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Mono<Optional<Teacher>> findOne(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return Mono.just(teacher);
    }

    public Optional<Teacher> findOne2(String id) {
        return teacherRepository.findById(id);
    }

    public Iterable<Teacher> findAll2() {
        return teacherRepository.findAll();
    }

    public Flux<Teacher> findAll(TeacherQo teacherQo) {
        Iterable<Teacher> teachers = teacherRepository.findAll();
        Flux<Teacher> teacherFlux = Flux.fromIterable(teachers).skip(2).take(2);
        return teacherFlux;
    }

    public Flux<Teacher> findAll3(TeacherQo teacherQo) {
//        String[] sortBy = teacherQo.getSortBy();
//        Sort.Direction direction = teacherQo.isDesc() ? Sort.Direction.DESC : Sort.Direction.ASC;
        PageRequest pageRequest = PageRequest.of(teacherQo.getPage(), teacherQo.getSize());
        Iterable<Teacher> teachers = teacherRepository.findAll(pageRequest);
        Flux<Teacher> teacherFlux = Flux.fromIterable(teachers);
        return teacherFlux;
    }

    public void deleteById(String id) {
        teacherRepository.deleteById(id);
    }

    public Mono<Teacher> save(Teacher teacher) {
        return Mono.just(teacherRepository.save(teacher));
    }
}
