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
import com.sparrow.security.admin.protocol.dto.AdminUserDTO;
import com.sparrow.security.admin.domain.bo.AdminUserBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class AdminUserAssemble{

    @Inject
    private BeanCopier beanCopier;

     public AdminUserDTO boAssembleDTO(AdminUserBO bo) {
        AdminUserDTO adminUser = new AdminUserDTO();
        beanCopier.copyProperties(bo, adminUser);
        adminUser.setStatus(bo.getStatus().getIdentity());
        return adminUser;
    }

     public List<AdminUserDTO> boListAssembleDTOList(List<AdminUserBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<AdminUserDTO> adminUserDTOList = new ArrayList<>(list.size());
        for (AdminUserBO adminUserBo : list) {
            adminUserDTOList.add(this.boAssembleDTO(adminUserBo));
        }
        return adminUserDTOList;
    }

    public PagerResult<AdminUserDTO> assemblePager(ListRecordTotalBO<AdminUserBO> adminUserListTotalRecord,
        SimplePager adminUserQuery) {
        List<AdminUserDTO> adminUserDTOList = this.boListAssembleDTOList(adminUserListTotalRecord.getList());
        PagerResult<AdminUserDTO> pagerResult = new PagerResult<>(adminUserQuery);
        pagerResult.setList(adminUserDTOList);
        pagerResult.setRecordTotal(adminUserListTotalRecord.getTotal());
        return pagerResult;
    }

}