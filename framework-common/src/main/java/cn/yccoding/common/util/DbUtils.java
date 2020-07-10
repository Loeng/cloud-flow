package cn.yccoding.common.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 数据库工具类
 *
 * @author YC
 * @since 2020/7/10
 **/
public class DbUtils {

    public static Long getSnowflakeId() {
        return IdWorker.getId();
    }
}
