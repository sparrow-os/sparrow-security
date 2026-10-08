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
import com.sparrow.protocol.constant.*;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.MicroServiceBO;
import com.sparrow.protocol.pager.SimplePager;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.security.admin.repository.MicroServiceRepository;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class MicroServiceService {
    @Inject
    private MicroServiceRepository microServiceRepository;

    private void validateSaveMicroService(MicroServiceParam microServiceParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(microServiceParam.getName()), SecurityAdminError.NAME_IS_EMPTY, MicroServiceSuffix.name);
    }

    public Long saveMicroService(MicroServiceParam microServiceParam) throws BusinessException {
        this.validateSaveMicroService(microServiceParam);
        return this.microServiceRepository.save(microServiceParam);
    }

    public Integer deleteMicroService(Set<Long> microServiceIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(microServiceIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.microServiceRepository.delete(microServiceIds);
    }

    public Integer enableMicroService(Set<Long> microServiceIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(microServiceIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.microServiceRepository.enable(microServiceIds);
    }

    public Integer disableMicroService(Set<Long> microServiceIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(microServiceIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.microServiceRepository.disable(microServiceIds);
    }

    public ListRecordTotalBO<MicroServiceBO> queryAllMicroService() {
        return queryMicroService(null);
    }

    
    
        public ListRecordTotalBO<MicroServiceBO> queryMicroService(MicroServiceQuery microServiceQuery) {
            Long totalRecord = this.microServiceRepository.getMicroServiceCount(microServiceQuery);
            List<MicroServiceBO> microServiceBoList = null;
            if (totalRecord > 0) {
                microServiceBoList = this.microServiceRepository.queryMicroServices(microServiceQuery);
            }
            return new ListRecordTotalBO<>(microServiceBoList, totalRecord);
        }
    





    public MicroServiceBO getMicroService(Long microServiceId) throws BusinessException {
         Asserts.isTrue(microServiceId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.microServiceRepository.getMicroService(microServiceId);
    }
    public List<KeyValue<Integer, String>> getMicroServiceKvs() {
        MicroServiceQuery microServiceQuery = new MicroServiceQuery();
        microServiceQuery.setStatus(StatusRecord.ENABLE.ordinal());
        microServiceQuery.setPageSize(-1);
        List<MicroServiceBO> microServiceBoList = this.microServiceRepository.queryMicroServices(microServiceQuery);
        List<KeyValue<Integer, String>> microServiceKvs = new ArrayList<>(microServiceBoList.size());
        for (MicroServiceBO microServiceBO : microServiceBoList) {
            microServiceKvs.add(new KeyValue<>(microServiceBO.getId().intValue(), microServiceBO.getDisplayText()));
        }
        return microServiceKvs;
    }
}