package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * 教师仓库类
 *
 * @author YC
 * @since 2020/7/10
 **/
public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
