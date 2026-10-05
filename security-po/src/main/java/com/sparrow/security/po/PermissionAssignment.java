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

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.dao.InputDatasource;
import com.sparrow.protocol.dao.enums.DatasourceType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_permission_assignments")
public class PermissionAssignment implements POJO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @InputDatasource(type = DatasourceType.ENUM, params = "t_role")
    @Column(name = "role_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '角色ID'", nullable = false)
    private Long roleId;

    @Column(name = "permission_id", columnDefinition = "int(11) DEFAULT 0 COMMENT '权限ID'", nullable = false)
    private Long permissionId;

    @Column(name = "create_user_id", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建人ID'", nullable = false, updatable = false)
    private Long createUserId;

    @Column(name = "gmt_create", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建时间'", nullable = false, updatable = false)
    private Long gmtCreate;

    @Column(name = "create_user_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '创建人'", nullable = false, updatable = false)
    private String createUserName;

    @Column(name = "modified_user_id", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '更新人ID'", nullable = false)
    private Long modifiedUserId;

    @Column(name = "gmt_modified", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '更新时间'", nullable = false)
    private Long gmtModified;

    @Column(name = "modified_user_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '更新人'", nullable = false)
    private String modifiedUserName;
}
