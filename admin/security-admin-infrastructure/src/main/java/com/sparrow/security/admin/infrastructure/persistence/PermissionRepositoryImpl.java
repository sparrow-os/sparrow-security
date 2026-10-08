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
import com.sparrow.security.admin.dao.PermissionDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.PermissionConverter;
import com.sparrow.security.po.Permission;
import com.sparrow.security.admin.domain.bo.PermissionBO;
import com.sparrow.security.admin.protocol.param.PermissionParam;
import com.sparrow.security.admin.repository.PermissionRepository;
import com.sparrow.security.admin.protocol.query.PermissionQuery;

import java.util.List;
import java.util.Set;
import jakarta.inject.*;

@Named
public class PermissionRepositoryImpl implements PermissionRepository {
    @Inject
    private PermissionConverter permissionConverter;

    @Inject
    private PermissionDAO permissionDao;

    @Override public Long save(PermissionParam permissionParam) {
        Permission permission = this.permissionConverter.param2po(permissionParam);
        if (permission.getId() != null) {
            this.permissionDao.update(permission);
            return permission.getId();
        }
        this.permissionDao.insert(permission);
        return permission.getId();
    }

    @Override public Integer delete(Set<Long> permissionIds) {
        return this.permissionDao.batchDelete(permissionIds);
    }

    @Override public Integer disable(Set<Long> permissionIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(permissionIds, StatusRecord.DISABLE);
        this.permissionConverter.convertStatus(statusCriteria);
        return this.permissionDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> permissionIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(permissionIds, StatusRecord.ENABLE);
        this.permissionConverter.convertStatus(statusCriteria);
        return this.permissionDao.changeStatus(statusCriteria);
    }

    @Override public PermissionBO getPermission(Long permissionId) {
        Permission permission = this.permissionDao.getEntity(permissionId);
        return this.permissionConverter.po2bo(permission);
    }

    @Override public List<PermissionBO> queryPermissions(PermissionQuery permissionQuery) {
        List<Permission> permissionList = this.permissionDao.queryPermissions(this.permissionConverter.toDbPagerQuery(permissionQuery));
        return this.permissionConverter.poList2BoList(permissionList);
    }

    @Override public Long getPermissionCount(PermissionQuery permissionQuery) {
        return this.permissionDao.countPermission(this.permissionConverter.toDbPagerQuery(permissionQuery));
    }
}