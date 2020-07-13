package cn.yccoding.edu.object;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询基础对象
 *
 * @author YC
 * @since 2020/7/12
 **/
@Getter
@Setter
public class PageQo {
    private Integer page = 0;
    private Integer size = 10;
}
