package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;

public class Role extends PO {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long appId;

    private String code;

    private String name;

    private Integer sort;
}
