package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.Chapter;
import org.springframework.data.repository.CrudRepository;

/**
 * 章节仓库类
 *
 * @author YC
 * @since 2020/7/16
 **/
public interface ChapterRepository extends CrudRepository<Chapter,String> {
}
