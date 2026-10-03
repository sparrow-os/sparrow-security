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
import jakarta.persistence.*;

import com.sparrow.protocol.POJO;

@Table(name = "t_rule_strategy")
public class RoleStrategy implements POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "role_id", columnDefinition = "int(11) unsigned default 0 comment 'role id'", nullable = false)
    private Long roleId;
    @Column(name = "strategy", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'strategy'", nullable = false)

    private String strategy;
    @Column(name = "value", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'config value'", nullable = false)

    private String value;


}
