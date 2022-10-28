package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "strategy")
public class Strategy implements POJO {
    private Long id;
    private Long groupId;
    private String strategy;
    private String value;

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
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    @MethodOrder(order = 3)
    @Column(name = "strategy", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '策略'", nullable = false)
    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @MethodOrder(order = 4)
    @Column(name = "value", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '配置值'", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
