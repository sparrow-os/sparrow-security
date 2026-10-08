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
import com.sparrow.security.admin.domain.bo.DictTypeBO;
import com.sparrow.security.admin.repository.DictTypeRepository;
import com.sparrow.security.admin.protocol.param.DictTypeParam;
import com.sparrow.security.admin.protocol.query.DictTypeQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class DictTypeService {
    @Inject
    private DictTypeRepository dictTypeRepository;

    private void validateSaveDictType(DictTypeParam dictTypeParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(dictTypeParam.getName()), SecurityAdminError.NAME_IS_EMPTY, DictTypeSuffix.name);
    }

    public Long saveDictType(DictTypeParam dictTypeParam) throws BusinessException {
        this.validateSaveDictType(dictTypeParam);
        return this.dictTypeRepository.save(dictTypeParam);
    }

    public Integer deleteDictType(Set<Long> dictTypeIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeRepository.delete(dictTypeIds);
    }

    public Integer enableDictType(Set<Long> dictTypeIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeRepository.enable(dictTypeIds);
    }

    public Integer disableDictType(Set<Long> dictTypeIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictTypeIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeRepository.disable(dictTypeIds);
    }

    public ListRecordTotalBO<DictTypeBO> queryAllDictType() {
        return queryDictType(null);
    }

    public ListRecordTotalBO<DictTypeBO> queryDictType(DictTypeQuery dictTypeQuery) {
        Long totalRecord = this.dictTypeRepository.getDictTypeCount(dictTypeQuery);
        List<DictTypeBO> dictTypeBoList = null;
        if (totalRecord > 0) {
            dictTypeBoList = this.dictTypeRepository.queryDictTypes(dictTypeQuery);
        }
        return new ListRecordTotalBO<>(dictTypeBoList, totalRecord);
    }

    public DictTypeBO getDictType(Long dictTypeId) throws BusinessException {
         Asserts.isTrue(dictTypeId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictTypeRepository.getDictType(dictTypeId);
    }
    public List<KeyValue<Integer, String>> getDictTypeKvs() {
        DictTypeQuery dictTypeQuery = new DictTypeQuery();
        dictTypeQuery.setStatus(StatusRecord.ENABLE.ordinal());
        dictTypeQuery.setPageSize(-1);
        List<DictTypeBO> dictTypeBoList = this.dictTypeRepository.queryDictTypes(dictTypeQuery);
        List<KeyValue<Integer, String>> dictTypeKvs = new ArrayList<>(dictTypeBoList.size());
        dictTypeKvs.add(new KeyValue<>(-1, "请选择[默认不限]"));
        for (DictTypeBO dictTypeBO : dictTypeBoList) {
            dictTypeKvs.add(new KeyValue<>(dictTypeBO.getId().intValue(), dictTypeBO.getDisplayText()));
        }
        return dictTypeKvs;
    }
}