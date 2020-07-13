package cn.yccoding.edu.domain.repository;

import cn.yccoding.edu.domain.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * 教师仓库类
 *
 * @author YC
 * @since 2020/7/10
 **/
public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
