package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.CourseDescription;
import org.springframework.data.repository.CrudRepository;

/**
 * 课程描述
 *
 * @author YC
 * @since 2020/7/16
 */

public interface CourseDescriptionRepository extends CrudRepository<CourseDescription,String> {
}
