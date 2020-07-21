package cn.yccoding.manage.domain.repository;

import cn.yccoding.manage.domain.entity.Video;
import org.springframework.data.repository.CrudRepository;

/**
 * video
 *
 * @author YC
 * @since 2020/7/16
 */
public interface VideoRepository extends CrudRepository<Video,String> {
}
