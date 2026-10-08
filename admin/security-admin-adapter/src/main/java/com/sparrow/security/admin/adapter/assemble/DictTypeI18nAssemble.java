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
package com.sparrow.security.admin.adapter.assemble;

import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.KeyValue;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.protocol.dto.DictTypeI18nDTO;
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictTypeI18nAssemble{

    @Inject
    private BeanCopier beanCopier;

     public DictTypeI18nDTO boAssembleDTO(DictTypeI18nBO bo) {
        DictTypeI18nDTO dictTypeI18n = new DictTypeI18nDTO();
        beanCopier.copyProperties(bo, dictTypeI18n);
        dictTypeI18n.setStatus(bo.getStatus().getIdentity());
        return dictTypeI18n;
    }

     public List<DictTypeI18nDTO> boListAssembleDTOList(List<DictTypeI18nBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<DictTypeI18nDTO> dictTypeI18nDTOList = new ArrayList<>(list.size());
        for (DictTypeI18nBO dictTypeI18nBo : list) {
            dictTypeI18nDTOList.add(this.boAssembleDTO(dictTypeI18nBo));
        }
        return dictTypeI18nDTOList;
    }

    public PagerResult<DictTypeI18nDTO> assemblePager(ListRecordTotalBO<DictTypeI18nBO> dictTypeI18nListTotalRecord,
        SimplePager dictTypeI18nQuery) {
        List<DictTypeI18nDTO> dictTypeI18nDTOList = this.boListAssembleDTOList(dictTypeI18nListTotalRecord.getList());
        PagerResult<DictTypeI18nDTO> pagerResult = new PagerResult<>(dictTypeI18nQuery);
        pagerResult.setList(dictTypeI18nDTOList);
        pagerResult.setRecordTotal(dictTypeI18nListTotalRecord.getTotal());
        return pagerResult;
    }

}