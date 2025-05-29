package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_privilege")
public class Privilege implements POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")

    private Long id;
    @Column(name = "role_id", columnDefinition = "int(11) unsigned default 0 comment 'role id'", nullable = false)

    private Long roleId;
    @Column(name = "resource_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'resource id'", nullable = false)
    private Long resourceId;

}
