package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;

@Table(name = "t_department")
@Data
public class Department extends PO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")

    private Long id;

    @Column(name = "pinyin", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'pinyin'", nullable = false, unique = true)
    private String pinyin;

    @Column(name = "code", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'code'", nullable = false, unique = true)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    private String name;

    @Column(name = "parent_id", columnDefinition = "int(11)unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)

    private String parentId;

    @Column(name = "manager", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人'", nullable = false)

    private String manager;

    @Column(name = "telephone", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人电话'", nullable = false)

    private String telephone;

    @Column(name = "type", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门类型'", nullable = false)

    private String type;

    @Column(name = "sort", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门排序号'", nullable = false)

    private Integer sort;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;
}
