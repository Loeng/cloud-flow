package cn.yccoding.edu.domain.service;

import cn.yccoding.edu.domain.entity.Teacher;
import cn.yccoding.edu.domain.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 教师服务类
 *
 * @author YC
 * @since 2020/7/12
 **/
@Service
@Transactional
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher findOne(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.isPresent()?teacher.get():null;
    }
}
