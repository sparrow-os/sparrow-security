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
import com.sparrow.security.admin.dao.UserGroupDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.UserGroupConverter;
import com.sparrow.security.po.UserGroup;
import com.sparrow.security.admin.domain.bo.UserGroupBO;
import com.sparrow.security.admin.protocol.param.UserGroupParam;
import com.sparrow.security.admin.repository.UserGroupRepository;
import com.sparrow.security.admin.protocol.query.UserGroupQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class UserGroupRepositoryImpl implements UserGroupRepository {
    @Inject
    private UserGroupConverter userGroupConverter;

    @Inject
    private UserGroupDAO userGroupDao;

    @Override public Long save(UserGroupParam userGroupParam) {
        UserGroup userGroup = this.userGroupConverter.param2po(userGroupParam);
        if (userGroup.getId() != null) {
            this.userGroupDao.update(userGroup);
            return userGroup.getId();
        }
        this.userGroupDao.insert(userGroup);
        return userGroup.getId();
    }

    @Override public Integer delete(Set<Long> userGroupIds) {
        return this.userGroupDao.batchDelete(userGroupIds);
    }

    @Override public Integer disable(Set<Long> userGroupIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(userGroupIds, StatusRecord.DISABLE);
        this.userGroupConverter.convertStatus(statusCriteria);
        return this.userGroupDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> userGroupIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(userGroupIds, StatusRecord.ENABLE);
        this.userGroupConverter.convertStatus(statusCriteria);
        return this.userGroupDao.changeStatus(statusCriteria);
    }

    @Override public UserGroupBO getUserGroup(Long userGroupId) {
        UserGroup userGroup = this.userGroupDao.getEntity(userGroupId);
        return this.userGroupConverter.po2bo(userGroup);
    }

    @Override public List<UserGroupBO> queryUserGroups(UserGroupQuery userGroupQuery) {
        List<UserGroup> userGroupList = this.userGroupDao.queryUserGroups(this.userGroupConverter.toDbPagerQuery(userGroupQuery));
        return this.userGroupConverter.poList2BoList(userGroupList);
    }

    @Override public Long getUserGroupCount(UserGroupQuery userGroupQuery) {
        return this.userGroupDao.countUserGroup(this.userGroupConverter.toDbPagerQuery(userGroupQuery));
    }

    
}