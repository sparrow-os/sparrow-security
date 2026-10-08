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
package com.sparrow.security.admin.repository;
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.security.admin.protocol.param.DictTypeI18nParam;
import com.sparrow.security.admin.protocol.query.DictTypeI18nQuery;
import java.util.List;
import java.util.Set;




public interface DictTypeI18nRepository {
    Long save(DictTypeI18nParam dictTypeI18nParam);

    Integer delete(Set<Long> dictTypeI18nIds);

    Integer disable(Set<Long> dictTypeI18nIds);

    Integer enable(Set<Long> dictTypeI18nIds);

    DictTypeI18nBO getDictTypeI18n(Long dictTypeI18nId);

    List<DictTypeI18nBO> queryDictTypeI18ns(DictTypeI18nQuery dictTypeI18nQuery);

    Long getDictTypeI18nCount(DictTypeI18nQuery dictTypeI18nQuery);

}