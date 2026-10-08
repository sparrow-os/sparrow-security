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
import com.sparrow.security.admin.domain.bo.RoleBO;
import com.sparrow.security.admin.repository.RoleRepository;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class RoleService {
    @Inject
    private RoleRepository roleRepository;

    private void validateSaveRole(RoleParam roleParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(roleParam.getName()), SecurityAdminError.NAME_IS_EMPTY, RoleSuffix.name);
    }

    public Long saveRole(RoleParam roleParam) throws BusinessException {
        this.validateSaveRole(roleParam);
        return this.roleRepository.save(roleParam);
    }

    public Integer deleteRole(Set<Long> roleIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(roleIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.roleRepository.delete(roleIds);
    }

    public Integer enableRole(Set<Long> roleIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(roleIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.roleRepository.enable(roleIds);
    }

    public Integer disableRole(Set<Long> roleIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(roleIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.roleRepository.disable(roleIds);
    }

    public ListRecordTotalBO<RoleBO> queryAllRole() {
        return queryRole(null);
    }

    public ListRecordTotalBO<RoleBO> queryRole(RoleQuery roleQuery) {
        Long totalRecord = this.roleRepository.getRoleCount(roleQuery);
        List<RoleBO> roleBoList = null;
        if (totalRecord > 0) {
            roleBoList = this.roleRepository.queryRoles(roleQuery);
        }
        return new ListRecordTotalBO<>(roleBoList, totalRecord);
    }

    public RoleBO getRole(Long roleId) throws BusinessException {
         Asserts.isTrue(roleId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.roleRepository.getRole(roleId);
    }
    
}