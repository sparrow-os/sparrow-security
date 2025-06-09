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
import com.sparrow.security.admin.dao.SparrowExampleDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.SparrowExampleConverter;
import com.sparrow.security.po.SparrowExample;
import com.sparrow.security.admin.domain.bo.SparrowExampleBO;
import com.sparrow.security.admin.protocol.param.SparrowExampleParam;
import com.sparrow.security.admin.repository.SparrowExampleRepository;
import com.sparrow.security.admin.protocol.query.SparrowExampleQuery;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SparrowExampleRepositoryImpl implements SparrowExampleRepository {
    @Inject
    private SparrowExampleConverter sparrowExampleConverter;

    @Inject
    private SparrowExampleDAO sparrowExampleDao;

    @Override public Long save(SparrowExampleParam sparrowExampleParam) {
        SparrowExample sparrowExample = this.sparrowExampleConverter.param2po(sparrowExampleParam);
        if (sparrowExample.getId() != null) {
            this.sparrowExampleDao.update(sparrowExample);
            return sparrowExample.getId();
        }
        this.sparrowExampleDao.insert(sparrowExample);
        return sparrowExample.getId();
    }

    @Override public Integer delete(String sparrowExampleIds) {
        return this.sparrowExampleDao.batchDelete(sparrowExampleIds);
    }

    @Override public Integer disable(String sparrowExampleIds) {
        StatusCriteria statusCriteria = new StatusCriteria(sparrowExampleIds, StatusRecord.DISABLE);
        this.sparrowExampleConverter.convertStatus(statusCriteria);
        return this.sparrowExampleDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(String sparrowExampleIds) {
        StatusCriteria statusCriteria = new StatusCriteria(sparrowExampleIds, StatusRecord.ENABLE);
        this.sparrowExampleConverter.convertStatus(statusCriteria);

        return this.sparrowExampleDao.changeStatus(statusCriteria);
    }

    @Override public SparrowExampleBO getSparrowExample(Long sparrowExampleId) {
        SparrowExample sparrowExample = this.sparrowExampleDao.getEntity(sparrowExampleId);
        return this.sparrowExampleConverter.po2bo(sparrowExample);
    }

    @Override public List<SparrowExampleBO> querySparrowExamples(SparrowExampleQuery sparrowExampleQuery) {
        List<SparrowExample> sparrowExampleList = this.sparrowExampleDao.querySparrowExamples(this.sparrowExampleConverter.toDbPagerQuery(sparrowExampleQuery));
        return this.sparrowExampleConverter.poList2BoList(sparrowExampleList);
    }

    @Override public Long getSparrowExampleCount(SparrowExampleQuery sparrowExampleQuery) {
        return this.sparrowExampleDao.countSparrowExample(this.sparrowExampleConverter.toDbPagerQuery(sparrowExampleQuery));
    }
}