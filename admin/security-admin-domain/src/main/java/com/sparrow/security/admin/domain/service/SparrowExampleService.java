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
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.domain.bo.SparrowExampleBO;
import com.sparrow.security.admin.repository.SparrowExampleRepository;
import com.sparrow.security.admin.protocol.param.SparrowExampleParam;
import com.sparrow.security.admin.protocol.query.SparrowExampleQuery;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SparrowExampleService {
    @Inject
    private SparrowExampleRepository sparrowExampleRepository;

    private void validateSaveSparrowExample(SparrowExampleParam sparrowExampleParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(sparrowExampleParam.getName()), SecurityAdminError.NAME_IS_EMPTY, SparrowExampleSuffix.name);
    }

    public Long saveSparrowExample(SparrowExampleParam sparrowExampleParam) throws BusinessException {
        this.validateSaveSparrowExample(sparrowExampleParam);
        return this.sparrowExampleRepository.save(sparrowExampleParam);
    }

    public Integer deleteSparrowExample(String sparrowExampleIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(sparrowExampleIds), SecurityAdminError.SparrowExample_ID_IS_EMPTY);
        return this.sparrowExampleRepository.delete(sparrowExampleIds);
    }

    public Integer enableSparrowExample(String sparrowExampleIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(sparrowExampleIds), SecurityAdminError.SparrowExample_ID_IS_EMPTY);
        return this.sparrowExampleRepository.enable(sparrowExampleIds);
    }

    public Integer disableSparrowExample(String sparrowExampleIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(sparrowExampleIds), SecurityAdminError.SparrowExample_ID_IS_EMPTY);
        return this.sparrowExampleRepository.disable(sparrowExampleIds);
    }

    public ListRecordTotalBO<SparrowExampleBO> queryAllSparrowExample() {
        return querySparrowExample(null);
    }

    public ListRecordTotalBO<SparrowExampleBO> querySparrowExample(SparrowExampleQuery sparrowExampleQuery) {
        Long totalRecord = this.sparrowExampleRepository.getSparrowExampleCount(sparrowExampleQuery);
        List<SparrowExampleBO> sparrowExampleBoList = null;
        if (totalRecord > 0) {
            sparrowExampleBoList = this.sparrowExampleRepository.querySparrowExamples(sparrowExampleQuery);
        }
        return new ListRecordTotalBO<>(sparrowExampleBoList, totalRecord);
    }

    public SparrowExampleBO getSparrowExample(Long sparrowExampleId) throws BusinessException {
        //Asserts.isTrue(sparrowExampleId == null, SecurityAdminError.sparrowExample_IS_EMPTY);
        return this.sparrowExampleRepository.getSparrowExample(sparrowExampleId);
    }
}