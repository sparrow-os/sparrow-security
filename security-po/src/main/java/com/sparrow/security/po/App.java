package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.dao.PO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "app")
public class App extends PO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String name;
    private String logo;
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

    @MethodOrder(order = 2)
    @Column(name = "code", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'code'", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @MethodOrder(order = 3)
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'name'", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MethodOrder(order = 4)
    @Column(name = "sort", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'sort'", nullable = false)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @MethodOrder(order = 5)
    @Column(name = "logo", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'sort'", nullable = false)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
