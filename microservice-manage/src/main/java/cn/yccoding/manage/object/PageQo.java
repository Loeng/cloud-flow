package cn.yccoding.manage.object;

import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * 基础分页
 *
 * @author YC
 * @since 2020/7/14
 **/
@Data
public class PageQo {

    private int page = 0;

    @Min(value = 5,message = "must between 5 and 25")
    @Min(value = 25,message = "must between 5 and 25")
    private int size = 10;

    private String[] sortBy = {"create_time"};

    /**
     * 是否降序
     */
    private boolean isDesc = false;
}
