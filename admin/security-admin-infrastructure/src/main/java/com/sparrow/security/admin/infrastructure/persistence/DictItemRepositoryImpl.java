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
package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.DictItemDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.DictItemConverter;
import com.sparrow.security.po.DictItem;
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.security.admin.protocol.param.DictItemParam;
import com.sparrow.security.admin.repository.DictItemRepository;
import com.sparrow.security.admin.protocol.query.DictItemQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class DictItemRepositoryImpl implements DictItemRepository {
    @Inject
    private DictItemConverter dictItemConverter;

    @Inject
    private DictItemDAO dictItemDao;

    @Override public Long save(DictItemParam dictItemParam) {
        DictItem dictItem = this.dictItemConverter.param2po(dictItemParam);
        if (dictItem.getId() != null) {
            this.dictItemDao.update(dictItem);
            return dictItem.getId();
        }
        this.dictItemDao.insert(dictItem);
        return dictItem.getId();
    }

    @Override public Integer delete(Set<Long> dictItemIds) {
        return this.dictItemDao.batchDelete(dictItemIds);
    }

    @Override public Integer disable(Set<Long> dictItemIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictItemIds, StatusRecord.DISABLE);
        this.dictItemConverter.convertStatus(statusCriteria);
        return this.dictItemDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> dictItemIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictItemIds, StatusRecord.ENABLE);
        this.dictItemConverter.convertStatus(statusCriteria);
        return this.dictItemDao.changeStatus(statusCriteria);
    }

    @Override public DictItemBO getDictItem(Long dictItemId) {
        DictItem dictItem = this.dictItemDao.getEntity(dictItemId);
        return this.dictItemConverter.po2bo(dictItem);
    }

    @Override public List<DictItemBO> queryDictItems(DictItemQuery dictItemQuery) {
        List<DictItem> dictItemList = this.dictItemDao.queryDictItems(this.dictItemConverter.toDbPagerQuery(dictItemQuery));
        return this.dictItemConverter.poList2BoList(dictItemList);
    }

    @Override public Long getDictItemCount(DictItemQuery dictItemQuery) {
        return this.dictItemDao.countDictItem(this.dictItemConverter.toDbPagerQuery(dictItemQuery));
    }
}