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
import com.sparrow.security.admin.protocol.dto.DictItemDTO;
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictItemAssemble{

    @Inject
    private BeanCopier beanCopier;

     public DictItemDTO boAssembleDTO(DictItemBO bo) {
        DictItemDTO dictItem = new DictItemDTO();
        beanCopier.copyProperties(bo, dictItem);
        dictItem.setStatus(bo.getStatus().getIdentity());
        return dictItem;
    }

     public List<DictItemDTO> boListAssembleDTOList(List<DictItemBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<DictItemDTO> dictItemDTOList = new ArrayList<>(list.size());
        for (DictItemBO dictItemBo : list) {
            dictItemDTOList.add(this.boAssembleDTO(dictItemBo));
        }
        return dictItemDTOList;
    }

    public PagerResult<DictItemDTO> assemblePager(ListRecordTotalBO<DictItemBO> dictItemListTotalRecord,
        SimplePager dictItemQuery) {
        List<DictItemDTO> dictItemDTOList = this.boListAssembleDTOList(dictItemListTotalRecord.getList());
        PagerResult<DictItemDTO> pagerResult = new PagerResult<>(dictItemQuery);
        pagerResult.setList(dictItemDTOList);
        pagerResult.setRecordTotal(dictItemListTotalRecord.getTotal());
        return pagerResult;
    }

}