package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.dao.PO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "group")
public class Group extends PO {
    private Long groupId;

    private Long parentGroupId;

    private String groupName;
    /**
     * 组内最大允许人数
     */
    private Long maxAllowCount;
    /**
     * 组类型
     */
    private String groupType;
    /**
     * 组的icon
     */
    private String groupIco;

    public Group() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @MethodOrder(order = 1)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @MethodOrder(order = 2)
    @Column(name = "group_type", columnDefinition = "varchar(8) default '' comment '组类别'", nullable = false)
    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @MethodOrder(order = 4)
    @Column(name = "group_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '组名'", nullable = false)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @MethodOrder(order = 7)
    @Column(name = "max_allow_count", columnDefinition = "int(11)DEFAULT 0 COMMENT '最大允许用户数'", nullable = false)
    public Long getMaxAllowCount() {
        return maxAllowCount;
    }

    public void setMaxAllowCount(Long maxAllowCount) {
        this.maxAllowCount = maxAllowCount;
    }

    @MethodOrder(order = 8)
    @Column(name = "group_ico", columnDefinition = "varchar(128) default '' comment ' 组图标'", nullable = false)
    public String getGroupIco() {
        return groupIco;
    }

    public void setGroupIco(String groupIco) {
        this.groupIco = groupIco;
    }

    @MethodOrder(order = 9)
    @Column(name = "parent_group_id", columnDefinition = "int(11) default '' comment ' parent group id'", nullable = false)
    public Long getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId) {
        this.parentGroupId = parentGroupId;
    }
}
