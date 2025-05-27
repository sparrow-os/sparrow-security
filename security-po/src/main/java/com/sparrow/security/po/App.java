package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "app")
public class App extends PO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "code", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'code'", nullable = false)
    private String code;
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'name'", nullable = false)
    private String name;
    @Column(name = "logo", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'sort'", nullable = false)
    private String logo;
    @Column(name = "sort", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'sort'", nullable = false)
    private Integer sort;
    @Column(name = "remark", columnDefinition = "varchar(512)  DEFAULT '' COMMENT 'remark'", nullable = false)
    private String remark;
    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;

}
