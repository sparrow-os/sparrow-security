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
import com.sparrow.security.admin.dao.DictTypeDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.DictTypeConverter;
import com.sparrow.security.po.DictType;
import com.sparrow.security.admin.domain.bo.DictTypeBO;
import com.sparrow.security.admin.protocol.param.DictTypeParam;
import com.sparrow.security.admin.repository.DictTypeRepository;
import com.sparrow.security.admin.protocol.query.DictTypeQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class DictTypeRepositoryImpl implements DictTypeRepository {
    @Inject
    private DictTypeConverter dictTypeConverter;

    @Inject
    private DictTypeDAO dictTypeDao;

    @Override public Long save(DictTypeParam dictTypeParam) {
        DictType dictType = this.dictTypeConverter.param2po(dictTypeParam);
        if (dictType.getId() != null) {
            this.dictTypeDao.update(dictType);
            return dictType.getId();
        }
        this.dictTypeDao.insert(dictType);
        return dictType.getId();
    }

    @Override public Integer delete(Set<Long> dictTypeIds) {
        return this.dictTypeDao.batchDelete(dictTypeIds);
    }

    @Override public Integer disable(Set<Long> dictTypeIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictTypeIds, StatusRecord.DISABLE);
        this.dictTypeConverter.convertStatus(statusCriteria);
        return this.dictTypeDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> dictTypeIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictTypeIds, StatusRecord.ENABLE);
        this.dictTypeConverter.convertStatus(statusCriteria);
        return this.dictTypeDao.changeStatus(statusCriteria);
    }

    @Override public DictTypeBO getDictType(Long dictTypeId) {
        DictType dictType = this.dictTypeDao.getEntity(dictTypeId);
        return this.dictTypeConverter.po2bo(dictType);
    }

    @Override public List<DictTypeBO> queryDictTypes(DictTypeQuery dictTypeQuery) {
        List<DictType> dictTypeList = this.dictTypeDao.queryDictTypes(this.dictTypeConverter.toDbPagerQuery(dictTypeQuery));
        return this.dictTypeConverter.poList2BoList(dictTypeList);
    }

    @Override public Long getDictTypeCount(DictTypeQuery dictTypeQuery) {
        return this.dictTypeDao.countDictType(this.dictTypeConverter.toDbPagerQuery(dictTypeQuery));
    }
}