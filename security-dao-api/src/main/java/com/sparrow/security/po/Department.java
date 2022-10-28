package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author harry
 */
@Table(name = "department")
public class Department implements POJO {
    /**
     * 部门组织架构ID
     */
    private Long id;
    /**
     * 部门组织拼音
     */
    private String pinyin;
    /**
     * 部门编码 每级增加编码3位依次类推
     */
    private String code;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 上级部门ID
     */
    private String parentId;

    /**
     * 部门负责人
     */
    private String manager;
    /**
     * 部门联系电话
     */
    private String telephone;
    /**
     * 部门类别
     */
    private String type;
    /**
     * 部门排列序号
     */
    private Integer sort;
    /**
     * 创建人ID
     */
    private Integer createUserId;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新人ID
     */
    private Integer updateUserId;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
    /**
     * 是否有效 1无效 0有效
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @MethodOrder(order = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'code'", nullable = false, unique = true)
    @MethodOrder(order = 2)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name",columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    @MethodOrder(order = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "pinyin",columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'pinyin'", nullable = false, unique = true)
    @MethodOrder(order = 3.1F)
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }


    @Column(name = "parent_id",columnDefinition = "int(11)unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)
    @MethodOrder(order = 4)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Column(name = "manager",columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人'", nullable = false)
    @MethodOrder(order = 5)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @MethodOrder(order = 6)
    @Column(name = "telephone",columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人电话'", nullable = false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "type",columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门类型'", nullable = false)
    @MethodOrder(order = 7)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "sort",columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门排序号'", nullable = false)
   @MethodOrder(order = 8)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @MethodOrder(order = 9)
    @Column(name = "create_user_id",columnDefinition = "int(11) unsigned  DEFAULT 0 COMMENT 'create user id'", nullable = false,updatable = false)
    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Column(name = "create_time",columnDefinition = "bigint(11)  DEFAULT 0 COMMENT 'create time'", nullable = false,updatable = false)
    @MethodOrder(order = 10)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @MethodOrder(order = 11)
    @Column(name = "update_user_id",columnDefinition = "int(11) unsigned  DEFAULT 0 COMMENT 'update user id'", nullable = false)
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    @MethodOrder(order = 12)
    @Column(name = "update_time",columnDefinition = "bigint(11)  DEFAULT 0 COMMENT 'update time'", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @MethodOrder(order = 13)
    @Column(name = "status",columnDefinition = "tinyint(1) DEFAULT 0 COMMENT 'status'",nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "remark",columnDefinition = "varchar(512)  DEFAULT '' COMMENT 'remark'", nullable = false)
    @MethodOrder(order = 14)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
