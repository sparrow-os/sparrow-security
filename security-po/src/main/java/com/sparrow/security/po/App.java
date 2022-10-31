package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;

/**
 * 应用表
 */
public class App extends PO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String name;
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
