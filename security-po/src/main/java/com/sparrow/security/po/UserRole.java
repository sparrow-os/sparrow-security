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
import lombok.Data;
import jakarta.persistence.*;


@Table(name = "t_user_role")
@Data
public class UserRole implements POJO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "user_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'user id'", nullable = false)
    private Long userId;

    @Column(name = "role_id", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'role id'", nullable = false)
    private Long roleId;

    @Column(name = "gmt_create", columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '创建时间'", nullable = false, updatable = false)
    private Long gmtCreate;

}
