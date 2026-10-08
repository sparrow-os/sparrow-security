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
package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.LoginUser;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.support.converter.POInitUtils;
import com.sparrow.security.admin.domain.bo.OrganizationBO;
import com.sparrow.security.po.Organization;
import com.sparrow.security.admin.protocol.param.OrganizationParam;
import com.sparrow.security.admin.protocol.query.OrganizationQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.OrganizationDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class OrganizationConverter implements Param2POConverter<OrganizationParam, Organization>, PO2BOConverter<OrganizationBO, Organization> {

    @Inject
    private BeanCopier beanCopier;

    public OrganizationDBPagerQuery toDbPagerQuery(OrganizationQuery organizationQuery) {
           if (organizationQuery == null) {
               return new OrganizationDBPagerQuery();
           }
           OrganizationDBPagerQuery organization = new OrganizationDBPagerQuery();
           beanCopier.copyProperties(organizationQuery, organization);
           return organization;
       }

    @Override public Organization param2po(OrganizationParam param) {
        Organization organization = new Organization();
        beanCopier.copyProperties(param, organization);
        POInitUtils.init(organization);

        return organization;
    }

    @Override public OrganizationBO po2bo(Organization organization) {
        OrganizationBO organizationBO = new OrganizationBO();
        beanCopier.copyProperties(organization, organizationBO);
        organizationBO.setDisplayText(organization.getDisplayText());
        return organizationBO;
    }

    @Override public List<OrganizationBO> poList2BoList(List<Organization> list) {
        List<OrganizationBO> organizationBos = new ArrayList<>(list.size());
        for (Organization organization : list) {
            organizationBos.add(this.po2bo(organization));
        }
        return organizationBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}