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


@Table(name = "t_group")
@Data
public class Group extends PO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long groupId;

    @Column(name = "group_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '组名'", nullable = false)
    private String groupName;

    @Column(name = "max_allow_count", columnDefinition = "int(11)DEFAULT 0 COMMENT '最大允许用户数'", nullable = false)
    private Long maxAllowCount;

    @Column(name = "group_type", columnDefinition = "varchar(8) default '' comment '组类别'", nullable = false)
    private String groupType;

    @Column(name = "group_ico", columnDefinition = "varchar(128) default '' comment ' 组图标'", nullable = false)
    private String groupIco;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;
}
