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
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.security.admin.protocol.param.DictItemParam;
import com.sparrow.security.admin.protocol.query.DictItemQuery;
import java.util.List;
import java.util.Set;




public interface DictItemRepository {
    Long save(DictItemParam dictItemParam);

    Integer delete(Set<Long> dictItemIds);

    Integer disable(Set<Long> dictItemIds);

    Integer enable(Set<Long> dictItemIds);

    DictItemBO getDictItem(Long dictItemId);

    List<DictItemBO> queryDictItems(DictItemQuery dictItemQuery);

    Long getDictItemCount(DictItemQuery dictItemQuery);

}