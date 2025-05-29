package com.sparrow.security.po;

import com.sparrow.protocol.POJO;

import javax.persistence.*;

@Table(name = "t_rule_strategy")
public class RoleStrategy implements POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "role_id", columnDefinition = "int(11) unsigned default 0 comment 'role id'", nullable = false)
    private Long roleId;
    @Column(name = "strategy", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'strategy'", nullable = false)

    private String strategy;
    @Column(name = "value", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'config value'", nullable = false)

    private String value;


}
