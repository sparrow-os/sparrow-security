package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.dao.PO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "group_role")
public class GroupRole extends PO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long groupId;
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

    @Column(name = "group_id", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'group id'", nullable = false)
    @MethodOrder(order = 2)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "role_id", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'role id'", nullable = false, unique = true)
    @MethodOrder(order = 3)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
