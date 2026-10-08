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
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.security.admin.repository.DictItemRepository;
import com.sparrow.security.admin.protocol.param.DictItemParam;
import com.sparrow.security.admin.protocol.query.DictItemQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class DictItemService {
    @Inject
    private DictItemRepository dictItemRepository;

    private void validateSaveDictItem(DictItemParam dictItemParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(dictItemParam.getName()), SecurityAdminError.NAME_IS_EMPTY, DictItemSuffix.name);
    }

    public Long saveDictItem(DictItemParam dictItemParam) throws BusinessException {
        this.validateSaveDictItem(dictItemParam);
        return this.dictItemRepository.save(dictItemParam);
    }

    public Integer deleteDictItem(Set<Long> dictItemIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemRepository.delete(dictItemIds);
    }

    public Integer enableDictItem(Set<Long> dictItemIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemRepository.enable(dictItemIds);
    }

    public Integer disableDictItem(Set<Long> dictItemIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(dictItemIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemRepository.disable(dictItemIds);
    }

    public ListRecordTotalBO<DictItemBO> queryAllDictItem() {
        return queryDictItem(null);
    }

    public ListRecordTotalBO<DictItemBO> queryDictItem(DictItemQuery dictItemQuery) {
        Long totalRecord = this.dictItemRepository.getDictItemCount(dictItemQuery);
        List<DictItemBO> dictItemBoList = null;
        if (totalRecord > 0) {
            dictItemBoList = this.dictItemRepository.queryDictItems(dictItemQuery);
        }
        return new ListRecordTotalBO<>(dictItemBoList, totalRecord);
    }

    public DictItemBO getDictItem(Long dictItemId) throws BusinessException {
         Asserts.isTrue(dictItemId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.dictItemRepository.getDictItem(dictItemId);
    }
    public List<KeyValue<Integer, String>> getDictItemKvs() {
        DictItemQuery dictItemQuery = new DictItemQuery();
        dictItemQuery.setStatus(StatusRecord.ENABLE.ordinal());
        dictItemQuery.setPageSize(-1);
        List<DictItemBO> dictItemBoList = this.dictItemRepository.queryDictItems(dictItemQuery);
        List<KeyValue<Integer, String>> dictItemKvs = new ArrayList<>(dictItemBoList.size());
        dictItemKvs.add(new KeyValue<>(-1, "请选择[默认不限]"));
        for (DictItemBO dictItemBO : dictItemBoList) {
            dictItemKvs.add(new KeyValue<>(dictItemBO.getId().intValue(), dictItemBO.getDisplayText()));
        }
        return dictItemKvs;
    }
}