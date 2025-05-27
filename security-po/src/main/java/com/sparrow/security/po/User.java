package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "user")
@Data
public class User extends PO {
    /*-------基本信息-------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long userId;
    @Column(name = "department_id", columnDefinition = " bigint(11) DEFAULT 0 COMMENT '部门ID'", updatable = false)
    private Long departmentId;
    @Column(name = "user_name", columnDefinition = " varchar(64) DEFAULT '' COMMENT '用户名'", updatable = false, unique = true)
    private String userName;
    @Column(name = "nick_name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '昵称'")
    private String nickName;

    @Column(name = "avatar", columnDefinition = "varchar(256) DEFAULT '' COMMENT '头象'", updatable = false)
    private String avatar;
    @Column(name = "gender", columnDefinition = "tinyint(2) DEFAULT 0 COMMENT '性别'")
    private Integer gender;
    @Column(name = "birthday", columnDefinition = "date COMMENT '生日'")
    private Date birthday;
    @Column(name = "email", columnDefinition = "varchar(256) DEFAULT '' comment 'E-MAIL'", unique = true, updatable = false)
    private String email;
    @Column(name = "mobile", columnDefinition = "varchar(11) DEFAULT '0' COMMENT '手机号码'", updatable = false)
    private String mobile;
}
