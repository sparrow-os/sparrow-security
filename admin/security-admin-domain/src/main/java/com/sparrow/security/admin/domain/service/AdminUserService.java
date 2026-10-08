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
package com.sparrow.security.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.*;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.AdminUserBO;
import com.sparrow.security.admin.repository.AdminUserRepository;
import com.sparrow.security.admin.protocol.param.AdminUserParam;
import com.sparrow.security.admin.protocol.query.AdminUserQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class AdminUserService {
    @Inject
    private AdminUserRepository adminUserRepository;

    private void validateSaveAdminUser(AdminUserParam adminUserParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(adminUserParam.getName()), SecurityAdminError.NAME_IS_EMPTY, AdminUserSuffix.name);
    }

    public Long saveAdminUser(AdminUserParam adminUserParam) throws BusinessException {
        this.validateSaveAdminUser(adminUserParam);
        return this.adminUserRepository.save(adminUserParam);
    }

    public Integer deleteAdminUser(Set<Long> adminUserIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(adminUserIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.adminUserRepository.delete(adminUserIds);
    }

    public Integer enableAdminUser(Set<Long> adminUserIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(adminUserIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.adminUserRepository.enable(adminUserIds);
    }

    public Integer disableAdminUser(Set<Long> adminUserIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(adminUserIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.adminUserRepository.disable(adminUserIds);
    }

    public ListRecordTotalBO<AdminUserBO> queryAllAdminUser() {
        return queryAdminUser(null);
    }

    public ListRecordTotalBO<AdminUserBO> queryAdminUser(AdminUserQuery adminUserQuery) {
        Long totalRecord = this.adminUserRepository.getAdminUserCount(adminUserQuery);
        List<AdminUserBO> adminUserBoList = null;
        if (totalRecord > 0) {
            adminUserBoList = this.adminUserRepository.queryAdminUsers(adminUserQuery);
        }
        return new ListRecordTotalBO<>(adminUserBoList, totalRecord);
    }

    public AdminUserBO getAdminUser(Long adminUserId) throws BusinessException {
         Asserts.isTrue(adminUserId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.adminUserRepository.getAdminUser(adminUserId);
    }
    
}