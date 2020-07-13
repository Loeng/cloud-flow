package cn.yccoding.edu.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户领域类
 *
 * @author YC
 * @since 2020/7/10
 **/
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;
}
