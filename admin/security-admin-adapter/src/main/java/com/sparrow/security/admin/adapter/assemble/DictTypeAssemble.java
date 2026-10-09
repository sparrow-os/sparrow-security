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
import com.sparrow.security.admin.protocol.dto.DictTypeDTO;
import com.sparrow.security.admin.domain.bo.DictTypeBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictTypeAssemble{

    @Inject
    private BeanCopier beanCopier;

     public DictTypeDTO boAssembleDTO(DictTypeBO bo) {
        DictTypeDTO dictType = new DictTypeDTO();
        beanCopier.copyProperties(bo, dictType);
        dictType.setStatus(bo.getStatus().getIdentity());
        return dictType;
    }

     public List<DictTypeDTO> boListAssembleDTOList(List<DictTypeBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<DictTypeDTO> dictTypeDTOList = new ArrayList<>(list.size());
        for (DictTypeBO dictTypeBo : list) {
            dictTypeDTOList.add(this.boAssembleDTO(dictTypeBo));
        }
        return dictTypeDTOList;
    }

    public PagerResult<DictTypeDTO> assemblePager(ListRecordTotalBO<DictTypeBO> dictTypeListTotalRecord,
        SimplePager dictTypeQuery) {
        List<DictTypeDTO> dictTypeDTOList = this.boListAssembleDTOList(dictTypeListTotalRecord.getList());
        PagerResult<DictTypeDTO> pagerResult = new PagerResult<>(dictTypeQuery);
        pagerResult.setList(dictTypeDTOList);
        pagerResult.setRecordTotal(dictTypeListTotalRecord.getTotal());
        return pagerResult;
    }

}