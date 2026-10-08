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
import com.sparrow.security.admin.dao.DictItemI18nDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.DictItemI18nConverter;
import com.sparrow.security.po.DictItemI18n;
import com.sparrow.security.admin.domain.bo.DictItemI18nBO;
import com.sparrow.security.admin.protocol.param.DictItemI18nParam;
import com.sparrow.security.admin.repository.DictItemI18nRepository;
import com.sparrow.security.admin.protocol.query.DictItemI18nQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class DictItemI18nRepositoryImpl implements DictItemI18nRepository {
    @Inject
    private DictItemI18nConverter dictItemI18nConverter;

    @Inject
    private DictItemI18nDAO dictItemI18nDao;

    @Override public Long save(DictItemI18nParam dictItemI18nParam) {
        DictItemI18n dictItemI18n = this.dictItemI18nConverter.param2po(dictItemI18nParam);
        if (dictItemI18n.getId() != null) {
            this.dictItemI18nDao.update(dictItemI18n);
            return dictItemI18n.getId();
        }
        this.dictItemI18nDao.insert(dictItemI18n);
        return dictItemI18n.getId();
    }

    @Override public Integer delete(Set<Long> dictItemI18nIds) {
        return this.dictItemI18nDao.batchDelete(dictItemI18nIds);
    }

    @Override public Integer disable(Set<Long> dictItemI18nIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictItemI18nIds, StatusRecord.DISABLE);
        this.dictItemI18nConverter.convertStatus(statusCriteria);
        return this.dictItemI18nDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> dictItemI18nIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(dictItemI18nIds, StatusRecord.ENABLE);
        this.dictItemI18nConverter.convertStatus(statusCriteria);
        return this.dictItemI18nDao.changeStatus(statusCriteria);
    }

    @Override public DictItemI18nBO getDictItemI18n(Long dictItemI18nId) {
        DictItemI18n dictItemI18n = this.dictItemI18nDao.getEntity(dictItemI18nId);
        return this.dictItemI18nConverter.po2bo(dictItemI18n);
    }

    @Override public List<DictItemI18nBO> queryDictItemI18ns(DictItemI18nQuery dictItemI18nQuery) {
        List<DictItemI18n> dictItemI18nList = this.dictItemI18nDao.queryDictItemI18ns(this.dictItemI18nConverter.toDbPagerQuery(dictItemI18nQuery));
        return this.dictItemI18nConverter.poList2BoList(dictItemI18nList);
    }

    @Override public Long getDictItemI18nCount(DictItemI18nQuery dictItemI18nQuery) {
        return this.dictItemI18nDao.countDictItemI18n(this.dictItemI18nConverter.toDbPagerQuery(dictItemI18nQuery));
    }
}