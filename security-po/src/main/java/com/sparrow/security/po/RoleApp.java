package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role_app")
public class RoleApp {
    private Long id;
    private Long appId;
    private Long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @MethodOrder(order = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @MethodOrder(order = 2)
    @Column(name = "role_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'role id'", nullable = false)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @MethodOrder(order = 2)
    @Column(name = "app_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
}
