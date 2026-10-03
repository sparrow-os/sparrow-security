/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sparrow.security.po;

import com.sparrow.protocol.DisplayTextAccessor;
import com.sparrow.protocol.dao.ListDatasource;
import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.dao.enums.ListDatasourceType;
import com.sparrow.protocol.enums.StatusRecord;
import jakarta.persistence.*;
import lombok.Data;


@Table(name = "t_department")
@Data
public class Department extends PO implements DisplayTextAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")

    private Long id;

    @Column(name = "pinyin", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '拼音'", nullable = false, unique = true)
    private String pinyin;

    @Column(name = "code", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '部门编码'", nullable = false, unique = true)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '部门名称'", nullable = false, unique = true)
    private String name;

    @Column(name = "parent_id", columnDefinition = "int(11)unsigned  DEFAULT 0 COMMENT '父部门'", nullable = false)
    @ListDatasource(type = ListDatasourceType.TABLE, params = "t_department")
    private String parentId;

    @Column(name = "manager", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人'", nullable = false)
    private String manager;

    @Column(name = "telephone", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '负责人电话'", nullable = false)
    private String telephone;

    @Column(name = "sort", columnDefinition = "varchar(16)  DEFAULT '' COMMENT '部门排序号'", nullable = false)
    private Integer sort;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'",
            nullable = false)
    @ListDatasource(type = ListDatasourceType.ENUM, params = "statusRecord")
    private StatusRecord status;

    @Override
    public String getDisplayText() {
        return this.name;
    }
}
