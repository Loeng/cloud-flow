package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * 课程
 *
 * @author YC
 * @since 2020/7/16
 **/
public interface CourseRepository extends CrudRepository<Course,String> {
}
