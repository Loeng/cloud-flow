package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author YC
 * @since 2020/7/16
 **/
public interface CommentRepository extends CrudRepository<Comment,String> {
}
