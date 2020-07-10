package cn.yccoding.edu.domain;

import cn.yccoding.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author yc
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
@Table(name = "edu_teacher")
public class Teacher extends BaseEntity implements Serializable {

    /**
     * 讲师ID
     */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "cn.yccoding.common.util.SnowflakeId")
    private String id;

    /**
     * 讲师姓名
     */
    private String name;

    /**
     * 讲师简介
     */
    private String intro;

    /**
     * 讲师资历,一句话说明讲师
     */
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Integer level;

    /**
     * 讲师头像
     */
    private String avatar;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 入驻时间
     */
    private LocalDateTime joinDate;
//
//    /**
//     * 逻辑删除 1（true）已删除， 0（false）未删除
//     */
//    @Column(name = "is_deleted")
//    private boolean deleted = false;
//
//    /**
//     * 创建时间
//     */
//    @Column(name = "create_time")
//    private LocalDateTime createTime;
//
//    /**
//     * 更新时间
//     */
//    @Column(name = "update_time")
//    private LocalDateTime updateTime;
//

}
