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
import com.sparrow.protocol.dao.InputDatasource;
import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.dao.enums.DatasourceType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_permission")
public class Permission extends PO implements DisplayTextAccessor {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID'", nullable = false)
    private Long tenantId;

    @Column(name = "permission_code", columnDefinition = "varchar(128) COMMENT '权限编码，如 order:create'", nullable = false)
    private String permissionCode;

    @Column(name = "permission_name", columnDefinition = "varchar(64) COMMENT '权限/菜单名称'", nullable = false)
    private String permissionName;

    /**
     * @see com.sparrow.security.commons.enums.PermissionType
     */
    @Column(name = "permission_type", columnDefinition = "tinyint DEFAULT 1 COMMENT '1菜单 2页面 3事件'", nullable = false)
    @InputDatasource(type = DatasourceType.ENUM, params = "PermissionType")
    private Integer permissionType;

    @InputDatasource(type = DatasourceType.TABLE, params = "t_app")
    @Column(name = "app_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT 'APP ID'", nullable = false)
    private Long appId;


    @InputDatasource(type = DatasourceType.TABLE, params = "t_micro_service")
    @Column(name = "micro_service_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '所属微服务ID'", nullable = false)
    private Long microServiceId;

    @InputDatasource(type = DatasourceType.TABLE, params = "t_permission")
    @Column(name = "parent_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '父节点ID'", nullable = false)
    private Long parentId;

    @Column(name = "operation", columnDefinition = "varchar(64) DEFAULT '' COMMENT '操作：view/create/update/delete/export'", nullable = false)
    private String operation;

    @Column(name = "object", columnDefinition = "varchar(64) DEFAULT '' COMMENT '对象/资源域：order/user/report'", nullable = false)
    private String object;

    @Column(name = "url", columnDefinition = "varchar(256) DEFAULT '' COMMENT '菜单/页面跳转地址'", nullable = false)
    private String url;

    @InputDatasource(type = DatasourceType.ENUM, params = "HttpMethod")
    @Column(name = "method", columnDefinition = "varchar(8) DEFAULT '' COMMENT 'HTTP方法，API用'", nullable = false)
    private String method;

    @Column(name = "icon", columnDefinition = "varchar(256) DEFAULT '' COMMENT '菜单图标'", nullable = false)
    private String icon;

    @InputDatasource(type = DatasourceType.ENUM, params = "HttpTarget")
    @Column(name = "target", columnDefinition = "varchar(16) DEFAULT '' COMMENT 'Target'", nullable = false)
    private String target;

    @Column(name = "sort", columnDefinition = "int DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;

    @Override
    public String getDisplayText() {
        return this.permissionName;
    }
}
