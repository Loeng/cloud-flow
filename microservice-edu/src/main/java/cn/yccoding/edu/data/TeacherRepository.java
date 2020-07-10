package cn.yccoding.edu.data;

import cn.yccoding.edu.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

/**
 * 教师仓库类
 *
 * @author YC
 * @since 2020/7/10
 **/
public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
