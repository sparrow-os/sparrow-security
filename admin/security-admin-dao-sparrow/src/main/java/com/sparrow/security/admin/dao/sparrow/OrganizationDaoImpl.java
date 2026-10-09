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
package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.*;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.OrganizationDAO;
import com.sparrow.security.admin.dao.query.OrganizationDBPagerQuery;
import com.sparrow.security.po.Organization;
import java.util.*;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class OrganizationDaoImpl extends ORMStrategy<Organization, Long> implements OrganizationDAO {
    @Override public List<Organization> queryOrganizations(OrganizationDBPagerQuery pagerOrganizationQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerOrganizationQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerOrganizationQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(Organization::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(OrganizationDBPagerQuery organizationQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(Organization::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(organizationQuery.getParentId()!=null&&organizationQuery.getParentId()>=0) {booleanCriteria.and(Criteria.field(Organization::getParentId).equal(organizationQuery.getParentId()));}if(organizationQuery.getStatus()!=null&&organizationQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(Organization::getStatus).equal(StatusRecord.valueOf(organizationQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countOrganization(OrganizationDBPagerQuery organizationPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(organizationPagerQuery));
        return this.getCount(searchCriteria);
    }


     
                @Override
                public List<Organization> queryChildren(OrganizationDBPagerQuery organizationPagerQuery) {
                    SearchCriteria searchCriteria = new SearchCriteria();
                    searchCriteria.setWhere(this.generateCriteria(organizationPagerQuery));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(Organization::getSort));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(Organization::getId));
                    return this.getList(searchCriteria);
                }

            @Override
            public Set<Long> getParentIdsHavingChildren(Collection<Long> parentIds,StatusRecord statusRecord) {
                if (parentIds == null || parentIds.isEmpty()) {
                    return Collections.emptySet();
                }
                SearchCriteria searchCriteria = new SearchCriteria();
                CriteriaField parentIdField = Criteria.field(Organization::getParentId).getField();
                searchCriteria.setFields(parentIdField.getAlias() + "." + parentIdField.getName());
                searchCriteria.setDistinct(true);

                BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field(Organization::getParentId).in(parentIds));
                        if (statusRecord != null) {
                            booleanCriteria.and(Criteria.field(Organization::getStatus).equal(statusRecord));
                        }

                searchCriteria.setWhere(booleanCriteria);

                Set<Object> rawParentIds = this.firstList(searchCriteria);
                Set<Long> parentIdsWithChildren = new HashSet<>(rawParentIds.size());
                for (Object rawParentId : rawParentIds) {
                    parentIdsWithChildren.add(((Number) rawParentId).longValue());
                }
                return parentIdsWithChildren;
            }
        
}