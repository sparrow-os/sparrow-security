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
import com.sparrow.security.admin.protocol.dto.UserGroupDTO;
import com.sparrow.security.admin.domain.bo.UserGroupBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class UserGroupAssemble{

    @Inject
    private BeanCopier beanCopier;

     public UserGroupDTO boAssembleDTO(UserGroupBO bo) {
        UserGroupDTO userGroup = new UserGroupDTO();
        beanCopier.copyProperties(bo, userGroup);
        userGroup.setStatus(bo.getStatus().getIdentity());
        return userGroup;
    }

     public List<UserGroupDTO> boListAssembleDTOList(List<UserGroupBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<UserGroupDTO> userGroupDTOList = new ArrayList<>(list.size());
        for (UserGroupBO userGroupBo : list) {
            userGroupDTOList.add(this.boAssembleDTO(userGroupBo));
        }
        return userGroupDTOList;
    }

    public PagerResult<UserGroupDTO> assemblePager(ListRecordTotalBO<UserGroupBO> userGroupListTotalRecord,
        SimplePager userGroupQuery) {
        List<UserGroupDTO> userGroupDTOList = this.boListAssembleDTOList(userGroupListTotalRecord.getList());
        PagerResult<UserGroupDTO> pagerResult = new PagerResult<>(userGroupQuery);
        pagerResult.setList(userGroupDTOList);
        pagerResult.setRecordTotal(userGroupListTotalRecord.getTotal());
        return pagerResult;
    }

}