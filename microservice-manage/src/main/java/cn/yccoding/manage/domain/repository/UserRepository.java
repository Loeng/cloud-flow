package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户仓库类
 *
 * @author YC
 * @since 2020/7/10
 **/
public interface UserRepository extends CrudRepository<User,Long> {
}
