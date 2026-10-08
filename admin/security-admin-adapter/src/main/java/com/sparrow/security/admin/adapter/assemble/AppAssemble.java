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
import com.sparrow.security.admin.protocol.dto.AppDTO;
import com.sparrow.security.admin.domain.bo.AppBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class AppAssemble{

    @Inject
    private BeanCopier beanCopier;

     public AppDTO boAssembleDTO(AppBO bo) {
        AppDTO app = new AppDTO();
        beanCopier.copyProperties(bo, app);
        app.setStatus(bo.getStatus().getIdentity());
        return app;
    }

     public List<AppDTO> boListAssembleDTOList(List<AppBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<AppDTO> appDTOList = new ArrayList<>(list.size());
        for (AppBO appBo : list) {
            appDTOList.add(this.boAssembleDTO(appBo));
        }
        return appDTOList;
    }

    public PagerResult<AppDTO> assemblePager(ListRecordTotalBO<AppBO> appListTotalRecord,
        SimplePager appQuery) {
        List<AppDTO> appDTOList = this.boListAssembleDTOList(appListTotalRecord.getList());
        PagerResult<AppDTO> pagerResult = new PagerResult<>(appQuery);
        pagerResult.setList(appDTOList);
        pagerResult.setRecordTotal(appListTotalRecord.getTotal());
        return pagerResult;
    }

}