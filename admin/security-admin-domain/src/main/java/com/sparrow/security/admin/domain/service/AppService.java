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

package com.sparrow.security.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.*;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.AppBO;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class AppService {
    @Inject
    private AppRepository appRepository;

    private void validateSaveApp(AppParam appParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(appParam.getName()), SecurityAdminError.NAME_IS_EMPTY, AppSuffix.name);
    }

    public Long saveApp(AppParam appParam) throws BusinessException {
        this.validateSaveApp(appParam);
        return this.appRepository.save(appParam);
    }

    public Integer deleteApp(Set<Long> appIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(appIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.appRepository.delete(appIds);
    }

    public Integer enableApp(Set<Long> appIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(appIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.appRepository.enable(appIds);
    }

    public Integer disableApp(Set<Long> appIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(appIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.appRepository.disable(appIds);
    }

    public ListRecordTotalBO<AppBO> queryAllApp() {
        return queryApp(null);
    }

    public ListRecordTotalBO<AppBO> queryApp(AppQuery appQuery) {
        Long totalRecord = this.appRepository.getAppCount(appQuery);
        List<AppBO> appBoList = null;
        if (totalRecord > 0) {
            appBoList = this.appRepository.queryApps(appQuery);
        }
        return new ListRecordTotalBO<>(appBoList, totalRecord);
    }

    public AppBO getApp(Long appId) throws BusinessException {
         Asserts.isTrue(appId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.appRepository.getApp(appId);
    }
    public List<KeyValue<Integer, String>> getAppKvs() {
        AppQuery appQuery = new AppQuery();
        appQuery.setStatus(StatusRecord.ENABLE.ordinal());
        appQuery.setPageSize(-1);
        List<AppBO> appBoList = this.appRepository.queryApps(appQuery);
        List<KeyValue<Integer, String>> appKvs = new ArrayList<>(appBoList.size());
        for (AppBO appBO : appBoList) {
            appKvs.add(new KeyValue<>(appBO.getId().intValue(), appBO.getDisplayText()));
        }
        return appKvs;
    }
}