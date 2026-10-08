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
import com.sparrow.security.admin.dao.MicroServiceDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.MicroServiceConverter;
import com.sparrow.security.po.MicroService;
import com.sparrow.security.admin.domain.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.repository.MicroServiceRepository;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class MicroServiceRepositoryImpl implements MicroServiceRepository {
    @Inject
    private MicroServiceConverter microServiceConverter;

    @Inject
    private MicroServiceDAO microServiceDao;

    @Override public Long save(MicroServiceParam microServiceParam) {
        MicroService microService = this.microServiceConverter.param2po(microServiceParam);
        if (microService.getId() != null) {
            this.microServiceDao.update(microService);
            return microService.getId();
        }
        this.microServiceDao.insert(microService);
        return microService.getId();
    }

    @Override public Integer delete(Set<Long> microServiceIds) {
        return this.microServiceDao.batchDelete(microServiceIds);
    }

    @Override public Integer disable(Set<Long> microServiceIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(microServiceIds, StatusRecord.DISABLE);
        this.microServiceConverter.convertStatus(statusCriteria);
        return this.microServiceDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> microServiceIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(microServiceIds, StatusRecord.ENABLE);
        this.microServiceConverter.convertStatus(statusCriteria);
        return this.microServiceDao.changeStatus(statusCriteria);
    }

    @Override public MicroServiceBO getMicroService(Long microServiceId) {
        MicroService microService = this.microServiceDao.getEntity(microServiceId);
        return this.microServiceConverter.po2bo(microService);
    }

    @Override public List<MicroServiceBO> queryMicroServices(MicroServiceQuery microServiceQuery) {
        List<MicroService> microServiceList = this.microServiceDao.queryMicroServices(this.microServiceConverter.toDbPagerQuery(microServiceQuery));
        return this.microServiceConverter.poList2BoList(microServiceList);
    }

    @Override public Long getMicroServiceCount(MicroServiceQuery microServiceQuery) {
        return this.microServiceDao.countMicroService(this.microServiceConverter.toDbPagerQuery(microServiceQuery));
    }
}