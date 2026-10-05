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
import com.sparrow.security.admin.protocol.dto.MicroServiceDTO;
import com.sparrow.security.admin.domain.bo.MicroServiceBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class MicroServiceAssemble{

    @Inject
    private BeanCopier beanCopier;

     public MicroServiceDTO boAssembleDTO(MicroServiceBO bo) {
        MicroServiceDTO microService = new MicroServiceDTO();
        beanCopier.copyProperties(bo, microService);
        microService.setStatus(bo.getStatus().getIdentity());
        return microService;
    }

     public List<MicroServiceDTO> boListAssembleDTOList(List<MicroServiceBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<MicroServiceDTO> microServiceDTOList = new ArrayList<>(list.size());
        for (MicroServiceBO microServiceBo : list) {
            microServiceDTOList.add(this.boAssembleDTO(microServiceBo));
        }
        return microServiceDTOList;
    }

    public PagerResult<MicroServiceDTO> assemblePager(ListRecordTotalBO<MicroServiceBO> microServiceListTotalRecord,
        SimplePager microServiceQuery) {
        List<MicroServiceDTO> microServiceDTOList = this.boListAssembleDTOList(microServiceListTotalRecord.getList());
        PagerResult<MicroServiceDTO> pagerResult = new PagerResult<>(microServiceQuery);
        pagerResult.setList(microServiceDTOList);
        pagerResult.setRecordTotal(microServiceListTotalRecord.getTotal());
        return pagerResult;
    }

}