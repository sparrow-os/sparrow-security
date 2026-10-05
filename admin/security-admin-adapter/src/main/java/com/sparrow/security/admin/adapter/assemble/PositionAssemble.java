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
import com.sparrow.security.admin.protocol.dto.PositionDTO;
import com.sparrow.security.admin.domain.bo.PositionBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class PositionAssemble{

    @Inject
    private BeanCopier beanCopier;

     public PositionDTO boAssembleDTO(PositionBO bo) {
        PositionDTO position = new PositionDTO();
        beanCopier.copyProperties(bo, position);
        position.setStatus(bo.getStatus().getIdentity());
        return position;
    }

     public List<PositionDTO> boListAssembleDTOList(List<PositionBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<PositionDTO> positionDTOList = new ArrayList<>(list.size());
        for (PositionBO positionBo : list) {
            positionDTOList.add(this.boAssembleDTO(positionBo));
        }
        return positionDTOList;
    }

    public PagerResult<PositionDTO> assemblePager(ListRecordTotalBO<PositionBO> positionListTotalRecord,
        SimplePager positionQuery) {
        List<PositionDTO> positionDTOList = this.boListAssembleDTOList(positionListTotalRecord.getList());
        PagerResult<PositionDTO> pagerResult = new PagerResult<>(positionQuery);
        pagerResult.setList(positionDTOList);
        pagerResult.setRecordTotal(positionListTotalRecord.getTotal());
        return pagerResult;
    }

}