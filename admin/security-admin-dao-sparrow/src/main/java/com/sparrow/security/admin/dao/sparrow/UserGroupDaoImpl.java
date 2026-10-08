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
import com.sparrow.security.admin.dao.UserGroupDAO;
import com.sparrow.security.admin.dao.query.UserGroupDBPagerQuery;
import com.sparrow.security.po.UserGroup;
import java.util.*;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class UserGroupDaoImpl extends ORMStrategy<UserGroup, Long> implements UserGroupDAO {
    @Override public List<UserGroup> queryUserGroups(UserGroupDBPagerQuery pagerUserGroupQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerUserGroupQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerUserGroupQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(UserGroup::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(UserGroupDBPagerQuery userGroupQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(UserGroup::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(userGroupQuery.getStatus()!=null&&userGroupQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(UserGroup::getStatus).equal(StatusRecord.valueOf(userGroupQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countUserGroup(UserGroupDBPagerQuery userGroupPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(userGroupPagerQuery));
        return this.getCount(searchCriteria);
    }


     
}