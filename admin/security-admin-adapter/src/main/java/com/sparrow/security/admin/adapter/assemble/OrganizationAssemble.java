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
import com.sparrow.security.admin.protocol.dto.OrganizationDTO;
import com.sparrow.security.admin.domain.bo.OrganizationBO;
import com.sparrow.utility.CollectionsUtility;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class OrganizationAssemble{

    @Inject
    private BeanCopier beanCopier;

     public OrganizationDTO boAssembleDTO(OrganizationBO bo) {
        OrganizationDTO organization = new OrganizationDTO();
        beanCopier.copyProperties(bo, organization);
        organization.setStatus(bo.getStatus().getIdentity());
        return organization;
    }

     public List<OrganizationDTO> boListAssembleDTOList(List<OrganizationBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<OrganizationDTO> organizationDTOList = new ArrayList<>(list.size());
        for (OrganizationBO organizationBo : list) {
            organizationDTOList.add(this.boAssembleDTO(organizationBo));
        }
        return organizationDTOList;
    }

    public PagerResult<OrganizationDTO> assemblePager(ListRecordTotalBO<OrganizationBO> organizationListTotalRecord,
        SimplePager organizationQuery) {
        List<OrganizationDTO> organizationDTOList = this.boListAssembleDTOList(organizationListTotalRecord.getList());
        PagerResult<OrganizationDTO> pagerResult = new PagerResult<>(organizationQuery);
        pagerResult.setList(organizationDTOList);
        pagerResult.setRecordTotal(organizationListTotalRecord.getTotal());
        return pagerResult;
    }

}