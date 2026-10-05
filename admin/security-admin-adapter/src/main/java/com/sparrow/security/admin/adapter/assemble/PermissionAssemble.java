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
import com.sparrow.security.admin.protocol.dto.PermissionDTO;
import com.sparrow.security.admin.domain.bo.PermissionBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class PermissionAssemble{

    @Inject
    private BeanCopier beanCopier;

     public PermissionDTO boAssembleDTO(PermissionBO bo) {
        PermissionDTO permission = new PermissionDTO();
        beanCopier.copyProperties(bo, permission);
        permission.setStatus(bo.getStatus().getIdentity());
        return permission;
    }

     public List<PermissionDTO> boListAssembleDTOList(List<PermissionBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<PermissionDTO> permissionDTOList = new ArrayList<>(list.size());
        for (PermissionBO permissionBo : list) {
            permissionDTOList.add(this.boAssembleDTO(permissionBo));
        }
        return permissionDTOList;
    }

    public PagerResult<PermissionDTO> assemblePager(ListRecordTotalBO<PermissionBO> permissionListTotalRecord,
        SimplePager permissionQuery) {
        List<PermissionDTO> permissionDTOList = this.boListAssembleDTOList(permissionListTotalRecord.getList());
        PagerResult<PermissionDTO> pagerResult = new PagerResult<>(permissionQuery);
        pagerResult.setList(permissionDTOList);
        pagerResult.setRecordTotal(permissionListTotalRecord.getTotal());
        return pagerResult;
    }

}