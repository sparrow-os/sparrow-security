package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "role")
public class Role extends PO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "app_id", columnDefinition = "bigint(11)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    private Long appId;

    @Column(name = "code", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'code'", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'name'", nullable = false)
    private String name;

    @Column(name = "sort", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'sort'", nullable = false)
    private Integer sort;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;

}
