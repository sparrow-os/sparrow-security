package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import lombok.Data;

import javax.persistence.*;

@Table(name = "t_inner_user")
@Data
public class User extends PO {
    /*-------基本信息-------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long userId;
    @Column(name = "department_id", columnDefinition = " bigint(11) DEFAULT 0 COMMENT '部门ID'", updatable = false)
    private Long departmentId;

}
