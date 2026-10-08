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

import com.sparrow.protocol.dao.InputDatasource;
import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.dao.enums.DatasourceType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_dict_item_i18n")
public class DictItemI18n extends PO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @InputDatasource(type = DatasourceType.TABLE, params = "t_dict_item")
    @Column(name = "dict_item_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_item.id（不可变）'", nullable = false, updatable = false)
    private Long dictItemId;

    @Column(name = "locale", columnDefinition = "varchar(10) DEFAULT '' COMMENT '语言标识（zh-CN/en-US/ja-JP等）'", nullable = false)
    @InputDatasource(type = DatasourceType.ENUM, params = "I18nLocale")
    private String locale;

    @Column(name = "item_label", columnDefinition = "varchar(200) DEFAULT '' COMMENT '字典项显示标签'", nullable = false)
    private String itemLabel;
}
