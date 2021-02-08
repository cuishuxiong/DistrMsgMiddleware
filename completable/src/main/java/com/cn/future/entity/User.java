package com.cn.future.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author csx
 * @Date 2/8/21 10:38 AM
 * @Description TODO
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pwd")
    private String pwd;

}
