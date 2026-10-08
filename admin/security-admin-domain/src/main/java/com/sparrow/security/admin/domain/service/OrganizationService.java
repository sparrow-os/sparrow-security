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
package com.sparrow.security.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.*;
import com.sparrow.protocol.constant.*;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.OrganizationBO;
import com.sparrow.protocol.pager.SimplePager;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.security.admin.repository.OrganizationRepository;
import com.sparrow.security.admin.protocol.param.OrganizationParam;
import com.sparrow.security.admin.protocol.query.OrganizationQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class OrganizationService {
    @Inject
    private OrganizationRepository organizationRepository;

    private void validateSaveOrganization(OrganizationParam organizationParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(organizationParam.getName()), SecurityAdminError.NAME_IS_EMPTY, OrganizationSuffix.name);
    }

    public Long saveOrganization(OrganizationParam organizationParam) throws BusinessException {
        this.validateSaveOrganization(organizationParam);
        return this.organizationRepository.save(organizationParam);
    }

    public Integer deleteOrganization(Set<Long> organizationIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(organizationIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.organizationRepository.delete(organizationIds);
    }

    public Integer enableOrganization(Set<Long> organizationIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(organizationIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.organizationRepository.enable(organizationIds);
    }

    public Integer disableOrganization(Set<Long> organizationIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(organizationIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.organizationRepository.disable(organizationIds);
    }

    public ListRecordTotalBO<OrganizationBO> queryAllOrganization() {
        return queryOrganization(null);
    }

    
     public ListRecordTotalBO<OrganizationBO> queryOrganization(OrganizationQuery organizationQuery) {
                List<OrganizationBO> organizationBoList = this.organizationRepository.queryChildren(organizationQuery);
                return new ListRecordTotalBO<>(organizationBoList, Constant.LONG_ALL);
        }
    
    





    public OrganizationBO getOrganization(Long organizationId) throws BusinessException {
         Asserts.isTrue(organizationId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.organizationRepository.getOrganization(organizationId);
    }
    public List<KeyValue<Integer, String>> getOrganizationKvs() {
        OrganizationQuery organizationQuery = new OrganizationQuery();
        organizationQuery.setStatus(StatusRecord.ENABLE.ordinal());
        organizationQuery.setPageSize(-1);
        List<OrganizationBO> organizationBoList = this.organizationRepository.queryOrganizations(organizationQuery);
        List<KeyValue<Integer, String>> organizationKvs = new ArrayList<>(organizationBoList.size());
        for (OrganizationBO organizationBO : organizationBoList) {
            organizationKvs.add(new KeyValue<>(organizationBO.getId().intValue(), organizationBO.getDisplayText()));
        }
        return organizationKvs;
    }
}