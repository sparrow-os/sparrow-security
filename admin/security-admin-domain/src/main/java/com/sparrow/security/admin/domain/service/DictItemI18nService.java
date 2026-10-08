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
import com.sparrow.security.admin.domain.bo.DictItemI18nBO;
import com.sparrow.security.admin.repository.DictItemI18nRepository;
import com.sparrow.security.admin.protocol.param.DictItemI18nParam;
import com.sparrow.security.admin.protocol.query.DictItemI18nQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class DictItemI18nService {
    @Inject
    private DictItemI18nRepository dictItemI18nRepository;

    private void validateSaveDictItemI18n(DictItemI18nParam dictItemI18nParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(dictItemI18nParam.getName()), SecurityAdminError.NAME_IS_EMPTY, DictItemI18nSuffix.name);
    }

    public Long saveDictItemI18n(DictItemI18nParam dictItemI18nParam) throws BusinessException {
        this.validateSaveDictItemI18n(dictItemI18nParam);
        return this.dictItemI18nRepository.save(dictItemI18nParam);
    }

    public Integer deleteDictItemI18n(Set<Long> dictItemI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemI18nRepository.delete(dictItemI18nIds);
    }

    public Integer enableDictItemI18n(Set<Long> dictItemI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemI18nRepository.enable(dictItemI18nIds);
    }

    public Integer disableDictItemI18n(Set<Long> dictItemI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemI18nRepository.disable(dictItemI18nIds);
    }

    public ListRecordTotalBO<DictItemI18nBO> queryAllDictItemI18n() {
        return queryDictItemI18n(null);
    }

    public ListRecordTotalBO<DictItemI18nBO> queryDictItemI18n(DictItemI18nQuery dictItemI18nQuery) {
        Long totalRecord = this.dictItemI18nRepository.getDictItemI18nCount(dictItemI18nQuery);
        List<DictItemI18nBO> dictItemI18nBoList = null;
        if (totalRecord > 0) {
            dictItemI18nBoList = this.dictItemI18nRepository.queryDictItemI18ns(dictItemI18nQuery);
        }
        return new ListRecordTotalBO<>(dictItemI18nBoList, totalRecord);
    }

    public DictItemI18nBO getDictItemI18n(Long dictItemI18nId) throws BusinessException {
         Asserts.isTrue(dictItemI18nId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemI18nRepository.getDictItemI18n(dictItemI18nId);
    }
    
}