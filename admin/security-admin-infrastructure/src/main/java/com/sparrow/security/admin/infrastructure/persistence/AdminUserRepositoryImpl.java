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
import com.sparrow.security.admin.dao.AdminUserDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.AdminUserConverter;
import com.sparrow.security.po.AdminUser;
import com.sparrow.security.admin.domain.bo.AdminUserBO;
import com.sparrow.security.admin.protocol.param.AdminUserParam;
import com.sparrow.security.admin.repository.AdminUserRepository;
import com.sparrow.security.admin.protocol.query.AdminUserQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class AdminUserRepositoryImpl implements AdminUserRepository {
    @Inject
    private AdminUserConverter adminUserConverter;

    @Inject
    private AdminUserDAO adminUserDao;

    @Override public Long save(AdminUserParam adminUserParam) {
        AdminUser adminUser = this.adminUserConverter.param2po(adminUserParam);
        if (adminUser.getId() != null) {
            this.adminUserDao.update(adminUser);
            return adminUser.getId();
        }
        this.adminUserDao.insert(adminUser);
        return adminUser.getId();
    }

    @Override public Integer delete(Set<Long> adminUserIds) {
        return this.adminUserDao.batchDelete(adminUserIds);
    }

    @Override public Integer disable(Set<Long> adminUserIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(adminUserIds, StatusRecord.DISABLE);
        this.adminUserConverter.convertStatus(statusCriteria);
        return this.adminUserDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> adminUserIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(adminUserIds, StatusRecord.ENABLE);
        this.adminUserConverter.convertStatus(statusCriteria);
        return this.adminUserDao.changeStatus(statusCriteria);
    }

    @Override public AdminUserBO getAdminUser(Long adminUserId) {
        AdminUser adminUser = this.adminUserDao.getEntity(adminUserId);
        return this.adminUserConverter.po2bo(adminUser);
    }

    @Override public List<AdminUserBO> queryAdminUsers(AdminUserQuery adminUserQuery) {
        List<AdminUser> adminUserList = this.adminUserDao.queryAdminUsers(this.adminUserConverter.toDbPagerQuery(adminUserQuery));
        return this.adminUserConverter.poList2BoList(adminUserList);
    }

    @Override public Long getAdminUserCount(AdminUserQuery adminUserQuery) {
        return this.adminUserDao.countAdminUser(this.adminUserConverter.toDbPagerQuery(adminUserQuery));
    }

    
}