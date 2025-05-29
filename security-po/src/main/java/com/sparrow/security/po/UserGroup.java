package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import lombok.Data;

import javax.persistence.*;

@Table(name = "t_user_group")
@Data
public class UserGroup implements POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "user_id",columnDefinition = "int(11) unsigned default 0 comment 'user id'",nullable = false)

    private Long userId;
    @Column(name = "group_id",columnDefinition = "int(11) unsigned default 0 comment 'group_id'",nullable = false)

    private Long groupId;

}
