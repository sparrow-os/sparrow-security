package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "group")
public class Group implements POJO {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    /**
     * 组类型
     */
    private String groupType;
    private Integer groupLevel;
    private String groupIco;
    private Integer cent;
    private String remark;
    private Long createTime;
    private Long updateTime;
    private Long createUserId;
    private Long updateUserId;
    private StatusRecord status;

    public Group() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId",columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @MethodOrder(order = 1)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }


    @MethodOrder(order = 2)
    @Column(name = "group_type",columnDefinition = "varchar(8) default '' comment '组类别'",nullable = false)
    public String getGroupType() {
        return groupType;
    }


    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @MethodOrder(order = 3)
    @Column(name = "group_level",columnDefinition = "int(11) unsigned default 0 comment '组级别'",nullable = false)
    public Integer getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(Integer groupLevel) {
        this.groupLevel = groupLevel;
    }


    @MethodOrder(order = 4)
    @Column(name = "group_name",columnDefinition="varchar(64) DEFAULT '' COMMENT '组名'",nullable = false)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    @MethodOrder(order = 4.1F)
    @Column(name = "cent",columnDefinition = "int(11) unsigned default 0 comment '积分'",nullable = false)
    public Integer getCent() {
        return cent;
    }

    public void setCent(Integer cent) {
        this.cent = cent;
    }

    @MethodOrder(order = 6)
    @Column(name = "status",columnDefinition = "tinyint(1) DEFAULT 0 COMMENT 'STATUS'",nullable = false)
    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }

    @MethodOrder(order = 7)
    @Column(name = "max_allow_count",columnDefinition = "int(11)DEFAULT 0 COMMENT '最大允许用户数'",nullable = false)
    public Long getMaxAllowCount() {
        return maxAllowCount;
    }

    public void setMaxAllowCount(Long maxAllowCount) {
        this.maxAllowCount = maxAllowCount;
    }

    @MethodOrder(order = 8)
    @Column(name = "group_ico",columnDefinition = "varchar(128) default '' comment ' 组图标'",nullable = false)
    public String getGroupIco() {
        return groupIco;
    }

    public void setGroupIco(String groupIco) {
        this.groupIco = groupIco;
    }


    @MethodOrder(order = 10)
    @Column(name = "create_time", updatable = false,columnDefinition = "bigint default 0 comment '创建时间'",nullable = false)
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @MethodOrder(order = 11)
    @Column(name = "update_time",columnDefinition = "bigint default 0 comment '更新时间'",nullable = false)
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @MethodOrder(order = 12)
    @Column(name = "create_user_id",columnDefinition = "bigint default 0 comment '创建用户id'",updatable = false)
    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    @MethodOrder(order = 13)
    @Column(name = "update_user_id",columnDefinition = "bigint default 0 comment '更新用户id'",nullable = false)
    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    @MethodOrder(order = 14)
    @Column(name = "remark",columnDefinition = "varchar(500) default '' comment 'remark'",nullable = false)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
