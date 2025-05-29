package com.sparrow.security.po;

import com.sparrow.protocol.POJO;

import javax.persistence.*;

@Table(name = "t_user_role")
public class UserRole implements POJO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "user_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'user id'", nullable = false)
    private Long userId;

    @Column(name = "role_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'role id'", nullable = false)
    private Long roleId;

    @Column(name = "gmt_create", columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '创建时间'", nullable = false, updatable = false)
    private Long gmtCreate;

}
