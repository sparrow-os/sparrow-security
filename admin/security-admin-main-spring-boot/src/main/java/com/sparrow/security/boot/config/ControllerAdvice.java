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
package com.sparrow.security.boot.config;

import com.sparrow.spring.mvc.ControllerReturnAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 这里需要业务手动设置扫描路径
 * 不要与sparrow 路径官方示例重叠
 */
@RestControllerAdvice(basePackages = {"com.sparrow.security"})
public class ControllerAdvice extends ControllerReturnAdvice {
}
