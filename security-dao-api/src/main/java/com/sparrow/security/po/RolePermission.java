package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "privilege")
public class RolePermission implements POJO {
    private Long id;
    private Long roleId;
    private String resource;

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

    @Column(name = "group_id", columnDefinition = "int(11) unsigned default 0 comment 'Group id'", nullable = false)
    @MethodOrder(order = 2)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @MethodOrder(order = 3)
    @Column(name = "resource", columnDefinition = "varchar(128)  DEFAULT '' COMMENT '资源配置'", nullable = false)
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
