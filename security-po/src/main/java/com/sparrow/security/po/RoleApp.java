package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_role_app")
@Data
public class RoleApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "app_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    private Long appId;
    @Column(name = "role_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'role id'", nullable = false)
    private Long roleId;
}
