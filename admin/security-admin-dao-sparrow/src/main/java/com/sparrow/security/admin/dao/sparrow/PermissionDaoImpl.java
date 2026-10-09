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
import com.sparrow.security.admin.dao.PermissionDAO;
import com.sparrow.security.admin.dao.query.PermissionDBPagerQuery;
import com.sparrow.security.po.Permission;
import java.util.*;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class PermissionDaoImpl extends ORMStrategy<Permission, Long> implements PermissionDAO {
    @Override public List<Permission> queryPermissions(PermissionDBPagerQuery pagerPermissionQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerPermissionQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerPermissionQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(Permission::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(PermissionDBPagerQuery permissionQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(Permission::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(permissionQuery.getParentId()!=null&&permissionQuery.getParentId()>=0) {booleanCriteria.and(Criteria.field(Permission::getParentId).equal(permissionQuery.getParentId()));}if(permissionQuery.getStatus()!=null&&permissionQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(Permission::getStatus).equal(StatusRecord.valueOf(permissionQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countPermission(PermissionDBPagerQuery permissionPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(permissionPagerQuery));
        return this.getCount(searchCriteria);
    }


     
                @Override
                public List<Permission> queryChildren(PermissionDBPagerQuery permissionPagerQuery) {
                    SearchCriteria searchCriteria = new SearchCriteria();
                    searchCriteria.setWhere(this.generateCriteria(permissionPagerQuery));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(Permission::getSort));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(Permission::getId));
                    return this.getList(searchCriteria);
                }

            @Override
            public Set<Long> getParentIdsHavingChildren(Collection<Long> parentIds,StatusRecord statusRecord) {
                if (parentIds == null || parentIds.isEmpty()) {
                    return Collections.emptySet();
                }
                SearchCriteria searchCriteria = new SearchCriteria();
                CriteriaField parentIdField = Criteria.field(Permission::getParentId).getField();
                searchCriteria.setFields(parentIdField.getAlias() + "." + parentIdField.getName());
                searchCriteria.setDistinct(true);

                BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field(Permission::getParentId).in(parentIds));
                        if (statusRecord != null) {
                            booleanCriteria.and(Criteria.field(Permission::getStatus).equal(statusRecord));
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