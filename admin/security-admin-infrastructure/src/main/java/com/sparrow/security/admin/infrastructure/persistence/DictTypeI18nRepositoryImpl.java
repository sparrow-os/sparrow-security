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
import com.sparrow.security.admin.dao.DictTypeI18nDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.DictTypeI18nConverter;
import com.sparrow.security.po.DictTypeI18n;
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.security.admin.protocol.param.DictTypeI18nParam;
import com.sparrow.security.admin.repository.DictTypeI18nRepository;
import com.sparrow.security.admin.protocol.query.DictTypeI18nQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class DictTypeI18nRepositoryImpl implements DictTypeI18nRepository {
    @Inject
    private DictTypeI18nConverter dictTypeI18nConverter;

    @Inject
    private DictTypeI18nDAO dictTypeI18nDao;

    @Override public Long save(DictTypeI18nParam dictTypeI18nParam) {
        DictTypeI18n dictTypeI18n = this.dictTypeI18nConverter.param2po(dictTypeI18nParam);
        if (dictTypeI18n.getId() != null) {
            this.dictTypeI18nDao.update(dictTypeI18n);
            return dictTypeI18n.getId();
        }
        this.dictTypeI18nDao.insert(dictTypeI18n);
        return dictTypeI18n.getId();
    }

    @Override public Integer delete(Set<Long> dictTypeI18nIds) {
        return this.dictTypeI18nDao.batchDelete(dictTypeI18nIds);
    }

    @Override public Integer disable(Set<Long> dictTypeI18nIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictTypeI18nIds, StatusRecord.DISABLE);
        this.dictTypeI18nConverter.convertStatus(statusCriteria);
        return this.dictTypeI18nDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> dictTypeI18nIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictTypeI18nIds, StatusRecord.ENABLE);
        this.dictTypeI18nConverter.convertStatus(statusCriteria);
        return this.dictTypeI18nDao.changeStatus(statusCriteria);
    }

    @Override public DictTypeI18nBO getDictTypeI18n(Long dictTypeI18nId) {
        DictTypeI18n dictTypeI18n = this.dictTypeI18nDao.getEntity(dictTypeI18nId);
        return this.dictTypeI18nConverter.po2bo(dictTypeI18n);
    }

    @Override public List<DictTypeI18nBO> queryDictTypeI18ns(DictTypeI18nQuery dictTypeI18nQuery) {
        List<DictTypeI18n> dictTypeI18nList = this.dictTypeI18nDao.queryDictTypeI18ns(this.dictTypeI18nConverter.toDbPagerQuery(dictTypeI18nQuery));
        return this.dictTypeI18nConverter.poList2BoList(dictTypeI18nList);
    }

    @Override public Long getDictTypeI18nCount(DictTypeI18nQuery dictTypeI18nQuery) {
        return this.dictTypeI18nDao.countDictTypeI18n(this.dictTypeI18nConverter.toDbPagerQuery(dictTypeI18nQuery));
    }

    
}