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
package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.OrganizationDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.OrganizationConverter;
import com.sparrow.security.po.Organization;
import com.sparrow.security.admin.domain.bo.OrganizationBO;
import com.sparrow.security.admin.protocol.param.OrganizationParam;
import com.sparrow.security.admin.repository.OrganizationRepository;
import com.sparrow.security.admin.protocol.query.OrganizationQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class OrganizationRepositoryImpl implements OrganizationRepository {
    @Inject
    private OrganizationConverter organizationConverter;

    @Inject
    private OrganizationDAO organizationDao;

    @Override public Long save(OrganizationParam organizationParam) {
        Organization organization = this.organizationConverter.param2po(organizationParam);
        if (organization.getId() != null) {
            this.organizationDao.update(organization);
            return organization.getId();
        }
        this.organizationDao.insert(organization);
        return organization.getId();
    }

    @Override public Integer delete(Set<Long> organizationIds) {
        return this.organizationDao.batchDelete(organizationIds);
    }

    @Override public Integer disable(Set<Long> organizationIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(organizationIds, StatusRecord.DISABLE);
        this.organizationConverter.convertStatus(statusCriteria);
        return this.organizationDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> organizationIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(organizationIds, StatusRecord.ENABLE);
        this.organizationConverter.convertStatus(statusCriteria);
        return this.organizationDao.changeStatus(statusCriteria);
    }

    @Override public OrganizationBO getOrganization(Long organizationId) {
        Organization organization = this.organizationDao.getEntity(organizationId);
        return this.organizationConverter.po2bo(organization);
    }

    @Override public List<OrganizationBO> queryOrganizations(OrganizationQuery organizationQuery) {
        List<Organization> organizationList = this.organizationDao.queryOrganizations(this.organizationConverter.toDbPagerQuery(organizationQuery));
        return this.organizationConverter.poList2BoList(organizationList);
    }

    @Override public Long getOrganizationCount(OrganizationQuery organizationQuery) {
        return this.organizationDao.countOrganization(this.organizationConverter.toDbPagerQuery(organizationQuery));
    }

    
    @Override public List<OrganizationBO> queryChildren(OrganizationQuery organizationQuery) {
        List<Organization> children = this.organizationDao.queryChildren(this.organizationConverter.toDbPagerQuery(organizationQuery));
        if (children.isEmpty()) {
            return Collections.emptyList();
        }
        Set<Long> childIds = children.stream().map(Organization::getId).collect(Collectors.toSet());
        Set<Long> parentIdsWithChildren = this.organizationDao.getParentIdsHavingChildren(childIds,StatusRecord.valueOf(organizationQuery.getStatus()));
        return children.stream().map(organization -> {
            OrganizationBO organizationBO = this.organizationConverter.po2bo(organization);
            organizationBO.setHasChildren(parentIdsWithChildren.contains(organization.getId()));
            return organizationBO;
        }).collect(Collectors.toList());
    }
    
}