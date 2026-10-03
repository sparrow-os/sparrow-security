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

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Table(name = "t_micro_service")
public class MicroService extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "url", columnDefinition = "varchar(256)  DEFAULT 0 COMMENT 'url'", nullable = false)

    private String url;
    @Column(name = "app_id", columnDefinition = "bigint(20)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    private Long appId;
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT 'name'", nullable = false)
    private String name;
    @Column(name = "logo", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'sort'", nullable = false)
    private String logo;
    @Column(name = "sort", columnDefinition = "int(10)  DEFAULT 0 COMMENT 'sort'", nullable = false)
    private Integer sort;
    @Column(name = "remark", columnDefinition = "varchar(512)  DEFAULT '' COMMENT 'remark'", nullable = false)
    private String remark;
    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;
}
