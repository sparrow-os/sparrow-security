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
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.protocol.pager.SimplePager;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.security.admin.repository.DictTypeI18nRepository;
import com.sparrow.security.admin.protocol.param.DictTypeI18nParam;
import com.sparrow.security.admin.protocol.query.DictTypeI18nQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class DictTypeI18nService {
    @Inject
    private DictTypeI18nRepository dictTypeI18nRepository;

    private void validateSaveDictTypeI18n(DictTypeI18nParam dictTypeI18nParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(dictTypeI18nParam.getName()), SecurityAdminError.NAME_IS_EMPTY, DictTypeI18nSuffix.name);
    }

    public Long saveDictTypeI18n(DictTypeI18nParam dictTypeI18nParam) throws BusinessException {
        this.validateSaveDictTypeI18n(dictTypeI18nParam);
        return this.dictTypeI18nRepository.save(dictTypeI18nParam);
    }

    public Integer deleteDictTypeI18n(Set<Long> dictTypeI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeI18nRepository.delete(dictTypeI18nIds);
    }

    public Integer enableDictTypeI18n(Set<Long> dictTypeI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeI18nRepository.enable(dictTypeI18nIds);
    }

    public Integer disableDictTypeI18n(Set<Long> dictTypeI18nIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeI18nIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeI18nRepository.disable(dictTypeI18nIds);
    }

    public ListRecordTotalBO<DictTypeI18nBO> queryAllDictTypeI18n() {
        return queryDictTypeI18n(null);
    }

    
    
        public ListRecordTotalBO<DictTypeI18nBO> queryDictTypeI18n(DictTypeI18nQuery dictTypeI18nQuery) {
            Long totalRecord = this.dictTypeI18nRepository.getDictTypeI18nCount(dictTypeI18nQuery);
            List<DictTypeI18nBO> dictTypeI18nBoList = null;
            if (totalRecord > 0) {
                dictTypeI18nBoList = this.dictTypeI18nRepository.queryDictTypeI18ns(dictTypeI18nQuery);
            }
            return new ListRecordTotalBO<>(dictTypeI18nBoList, totalRecord);
        }
    





    public DictTypeI18nBO getDictTypeI18n(Long dictTypeI18nId) throws BusinessException {
         Asserts.isTrue(dictTypeI18nId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeI18nRepository.getDictTypeI18n(dictTypeI18nId);
    }
    
}