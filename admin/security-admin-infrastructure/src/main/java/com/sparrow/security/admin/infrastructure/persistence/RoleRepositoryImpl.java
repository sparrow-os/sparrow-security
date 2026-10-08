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
import com.sparrow.security.admin.dao.RoleDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.RoleConverter;
import com.sparrow.security.po.Role;
import com.sparrow.security.admin.domain.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.repository.RoleRepository;
import com.sparrow.security.admin.protocol.query.RoleQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class RoleRepositoryImpl implements RoleRepository {
    @Inject
    private RoleConverter roleConverter;

    @Inject
    private RoleDAO roleDao;

    @Override public Long save(RoleParam roleParam) {
        Role role = this.roleConverter.param2po(roleParam);
        if (role.getId() != null) {
            this.roleDao.update(role);
            return role.getId();
        }
        this.roleDao.insert(role);
        return role.getId();
    }

    @Override public Integer delete(Set<Long> roleIds) {
        return this.roleDao.batchDelete(roleIds);
    }

    @Override public Integer disable(Set<Long> roleIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(roleIds, StatusRecord.DISABLE);
        this.roleConverter.convertStatus(statusCriteria);
        return this.roleDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> roleIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(roleIds, StatusRecord.ENABLE);
        this.roleConverter.convertStatus(statusCriteria);
        return this.roleDao.changeStatus(statusCriteria);
    }

    @Override public RoleBO getRole(Long roleId) {
        Role role = this.roleDao.getEntity(roleId);
        return this.roleConverter.po2bo(role);
    }

    @Override public List<RoleBO> queryRoles(RoleQuery roleQuery) {
        List<Role> roleList = this.roleDao.queryRoles(this.roleConverter.toDbPagerQuery(roleQuery));
        return this.roleConverter.poList2BoList(roleList);
    }

    @Override public Long getRoleCount(RoleQuery roleQuery) {
        return this.roleDao.countRole(this.roleConverter.toDbPagerQuery(roleQuery));
    }
}