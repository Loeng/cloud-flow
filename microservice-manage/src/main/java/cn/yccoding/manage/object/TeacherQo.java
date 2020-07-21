package cn.yccoding.manage.object;

import lombok.Data;

/**
 * 教师条件查询
 *
 * @author YC
 * @since 2020/7/16
 */
@Data
public class TeacherQo extends PageQo{


    private String id;

    private String teacherName;

    private String level;


}
