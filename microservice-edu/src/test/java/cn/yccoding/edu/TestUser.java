package cn.yccoding.edu;

import cn.yccoding.edu.domain.repository.TeacherRepository;
import cn.yccoding.edu.domain.repository.UserRepository;
import cn.yccoding.edu.domain.entity.Teacher;
import cn.yccoding.edu.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * 用户测试类
 *
 * @author YC
 * @since 2020/7/10
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("wx");
        user.setAge(10);
        userRepository.save(user);
        System.out.println(user.getId());
    }

    @Test
    public void testSelect() {
        Teacher teacher = new Teacher();
        teacher.setName("王6狗").setCareer("老师").setIntro("王老师").setLevel(1)
                .setSort(2).setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        teacherRepository.save(teacher);
        System.out.println(teacher);
    }
}
