package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import lombok.Data;

import javax.persistence.*;

@Table(name = "group_role")
@Data
public class GroupRole extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "group_id", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'group id'", nullable = false)
    private Long groupId;
    @Column(name = "role_id", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'role id'", nullable = false, unique = true)
    private Long roleId;
}
