package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import com.sparrow.protocol.dao.PO;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "department")
public class Department extends PO {

    private Long id;

    private String pinyin;

    private String code;

    private String name;

    private String parentId;

    private String manager;

    private String telephone;

    private String type;
   
    private Integer sort;

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

    @Column(name = "code", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'code'", nullable = false, unique = true)
    @MethodOrder(order = 2)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    @MethodOrder(order = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "pinyin", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'pinyin'", nullable = false, unique = true)
    @MethodOrder(order = 3.1F)
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Column(name = "parent_id", columnDefinition = "int(11)unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)
    @MethodOrder(order = 4)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Column(name = "manager", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人'", nullable = false)
    @MethodOrder(order = 5)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @MethodOrder(order = 6)
    @Column(name = "telephone", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人电话'", nullable = false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "type", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门类型'", nullable = false)
    @MethodOrder(order = 7)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "sort", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门排序号'", nullable = false)
    @MethodOrder(order = 8)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
