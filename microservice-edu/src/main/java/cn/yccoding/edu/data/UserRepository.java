package cn.yccoding.edu.data;

import cn.yccoding.edu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户仓库类
 *
 * @author YC
 * @since 2020/7/10
 **/
public interface UserRepository extends CrudRepository<User,Long> {
}
