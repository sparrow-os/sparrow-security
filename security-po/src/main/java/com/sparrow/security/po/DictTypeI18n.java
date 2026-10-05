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
@Table(name = "t_dict_type_i18n")
public class DictTypeI18n extends PO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "dict_type_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id（不可变）'", nullable = false, updatable = false)
    private Long dictTypeId;

    @Column(name = "locale", columnDefinition = "varchar(10) DEFAULT '' COMMENT '语言标识（zh-CN/en-US/ja-JP等）'", nullable = false)
    private String locale;

    @Column(name = "type_name", columnDefinition = "varchar(200) DEFAULT '' COMMENT '字典类型显示名称'", nullable = false)
    private String typeName;
}
