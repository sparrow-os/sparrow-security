/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sparrow.security.admin.starter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 一键接入 sparrow-security admin 的开关注解。
 *
 * <p>第三方项目在启动类上标注 {@code @EnableSecurity}，即通过 {@code @Import} 触发
 * {@link SecurityAutoConfiguration}，组件扫描 {@code com.sparrow.security.admin} 包下的
 * controller/service/repository/dao，无需手动编写任何 Spring controller。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(SecurityAutoConfiguration.class)
public @interface EnableSecurity {
}
