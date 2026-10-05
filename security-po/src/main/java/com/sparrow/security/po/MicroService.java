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
@Table(name = "t_micro_service")
public class MicroService extends PO implements DisplayTextAccessor {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "name", columnDefinition = "varchar(32) DEFAULT '' COMMENT '微服务名称'", nullable = false)
    private String name;

    @Column(name = "sort", columnDefinition = "int DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;

    @Column(name = "logo", columnDefinition = "varchar(256) DEFAULT '' COMMENT 'logo地址'", nullable = false)
    @InputDatasource(type = DatasourceType.UPLOAD, params = "micro_service_logo", defaultValue = "")
    private String logo;

    @Column(name = "app_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '所属APP ID'", nullable = false)
    @InputDatasource(type = DatasourceType.TABLE, params = "t_app")
    private Long appId;

    @Column(name = "url", columnDefinition = "varchar(256) DEFAULT '' COMMENT '微服务URL/路径'", nullable = false)
    private String url;

    @Column(name = "remark", columnDefinition = "varchar(512) DEFAULT '' COMMENT '备注'", nullable = false)
    private String remark;

    @Override
    public String getDisplayText() {
        return this.name;
    }
}
