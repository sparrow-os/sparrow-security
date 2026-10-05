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
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_dict_item")
public class DictItem extends PO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "dict_type_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id'", nullable = false)
    private Long dictTypeId;

    @Column(name = "item_code", columnDefinition = "varchar(100) DEFAULT '' COMMENT '字典项编码（不可变）'", nullable = false, updatable = false)
    private String itemCode;

    @Column(name = "item_value", columnDefinition = "varchar(500) DEFAULT '' COMMENT '字典项值（存储实际业务值）'")
    private String itemValue;

    @Column(name = "sort_order", columnDefinition = "int DEFAULT 0 COMMENT '排序号'", nullable = false)
    private Integer sortOrder;

    @Column(name = "remark", columnDefinition = "varchar(500) DEFAULT '' COMMENT '备注'")
    private String remark;
}
