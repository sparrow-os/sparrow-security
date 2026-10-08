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
import com.sparrow.security.admin.dao.RoleDAO;
import com.sparrow.security.admin.dao.query.RoleDBPagerQuery;
import com.sparrow.security.po.Role;
import java.util.List;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class RoleDaoImpl extends ORMStrategy<Role, Long> implements RoleDAO {
    @Override public List<Role> queryRoles(RoleDBPagerQuery pagerRoleQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerRoleQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerRoleQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(Role::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(RoleDBPagerQuery roleQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(Role::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(roleQuery.getStatus()!=null&&roleQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(Role::getStatus).equal(StatusRecord.valueOf(roleQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countRole(RoleDBPagerQuery rolePagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(rolePagerQuery));
        return this.getCount(searchCriteria);
    }
}