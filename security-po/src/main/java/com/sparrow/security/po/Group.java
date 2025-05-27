package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;

@Table(name = "group")
@Data
public class Group extends PO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long groupId;

    @Column(name = "group_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '组名'", nullable = false)
    private String groupName;

    @Column(name = "max_allow_count", columnDefinition = "int(11)DEFAULT 0 COMMENT '最大允许用户数'", nullable = false)
    private Long maxAllowCount;

    @Column(name = "group_type", columnDefinition = "varchar(8) default '' comment '组类别'", nullable = false)
    private String groupType;

    @Column(name = "group_ico", columnDefinition = "varchar(128) default '' comment ' 组图标'", nullable = false)
    private String groupIco;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;
}
