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
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.protocol.dto.DictItemI18nDTO;
import com.sparrow.security.admin.domain.bo.DictItemI18nBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictItemI18nAssemble{

    @Inject
    private BeanCopier beanCopier;

     public DictItemI18nDTO boAssembleDTO(DictItemI18nBO bo) {
        DictItemI18nDTO dictItemI18n = new DictItemI18nDTO();
        beanCopier.copyProperties(bo, dictItemI18n);
        dictItemI18n.setStatus(bo.getStatus().getIdentity());
        return dictItemI18n;
    }

     public List<DictItemI18nDTO> boListAssembleDTOList(List<DictItemI18nBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<DictItemI18nDTO> dictItemI18nDTOList = new ArrayList<>(list.size());
        for (DictItemI18nBO dictItemI18nBo : list) {
            dictItemI18nDTOList.add(this.boAssembleDTO(dictItemI18nBo));
        }
        return dictItemI18nDTOList;
    }

    public PagerResult<DictItemI18nDTO> assemblePager(ListRecordTotalBO<DictItemI18nBO> dictItemI18nListTotalRecord,
        SimplePager dictItemI18nQuery) {
        List<DictItemI18nDTO> dictItemI18nDTOList = this.boListAssembleDTOList(dictItemI18nListTotalRecord.getList());
        PagerResult<DictItemI18nDTO> pagerResult = new PagerResult<>(dictItemI18nQuery);
        pagerResult.setList(dictItemI18nDTOList);
        pagerResult.setRecordTotal(dictItemI18nListTotalRecord.getTotal());
        return pagerResult;
    }

}