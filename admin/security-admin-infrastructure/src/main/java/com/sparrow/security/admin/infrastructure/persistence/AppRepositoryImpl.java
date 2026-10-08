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
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.AppConverter;
import com.sparrow.security.po.App;
import com.sparrow.security.admin.domain.bo.AppBO;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.protocol.query.AppQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class AppRepositoryImpl implements AppRepository {
    @Inject
    private AppConverter appConverter;

    @Inject
    private AppDAO appDao;

    @Override public Long save(AppParam appParam) {
        App app = this.appConverter.param2po(appParam);
        if (app.getId() != null) {
            this.appDao.update(app);
            return app.getId();
        }
        this.appDao.insert(app);
        return app.getId();
    }

    @Override public Integer delete(Set<Long> appIds) {
        return this.appDao.batchDelete(appIds);
    }

    @Override public Integer disable(Set<Long> appIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(appIds, StatusRecord.DISABLE);
        this.appConverter.convertStatus(statusCriteria);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> appIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(appIds, StatusRecord.ENABLE);
        this.appConverter.convertStatus(statusCriteria);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override public AppBO getApp(Long appId) {
        App app = this.appDao.getEntity(appId);
        return this.appConverter.po2bo(app);
    }

    @Override public List<AppBO> queryApps(AppQuery appQuery) {
        List<App> appList = this.appDao.queryApps(this.appConverter.toDbPagerQuery(appQuery));
        return this.appConverter.poList2BoList(appList);
    }

    @Override public Long getAppCount(AppQuery appQuery) {
        return this.appDao.countApp(this.appConverter.toDbPagerQuery(appQuery));
    }

    
}