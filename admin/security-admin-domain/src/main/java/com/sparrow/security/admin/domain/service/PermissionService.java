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
import com.sparrow.protocol.constant.*;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.PermissionBO;
import com.sparrow.protocol.pager.SimplePager;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.security.admin.repository.PermissionRepository;
import com.sparrow.security.admin.protocol.param.PermissionParam;
import com.sparrow.security.admin.protocol.query.PermissionQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class PermissionService {
    @Inject
    private PermissionRepository permissionRepository;

    private void validateSavePermission(PermissionParam permissionParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(permissionParam.getName()), SecurityAdminError.NAME_IS_EMPTY, PermissionSuffix.name);
    }

    public Long savePermission(PermissionParam permissionParam) throws BusinessException {
        this.validateSavePermission(permissionParam);
        return this.permissionRepository.save(permissionParam);
    }

    public Integer deletePermission(Set<Long> permissionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(permissionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.permissionRepository.delete(permissionIds);
    }

    public Integer enablePermission(Set<Long> permissionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(permissionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.permissionRepository.enable(permissionIds);
    }

    public Integer disablePermission(Set<Long> permissionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(permissionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.permissionRepository.disable(permissionIds);
    }

    public ListRecordTotalBO<PermissionBO> queryAllPermission() {
        return queryPermission(null);
    }

    
    
        public ListRecordTotalBO<PermissionBO> queryPermission(PermissionQuery permissionQuery) {
            Long totalRecord = this.permissionRepository.getPermissionCount(permissionQuery);
            List<PermissionBO> permissionBoList = null;
            if (totalRecord > 0) {
                permissionBoList = this.permissionRepository.queryPermissions(permissionQuery);
            }
            return new ListRecordTotalBO<>(permissionBoList, totalRecord);
        }
    





    public PermissionBO getPermission(Long permissionId) throws BusinessException {
         Asserts.isTrue(permissionId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.permissionRepository.getPermission(permissionId);
    }
    public List<KeyValue<Integer, String>> getPermissionKvs() {
        PermissionQuery permissionQuery = new PermissionQuery();
        permissionQuery.setStatus(StatusRecord.ENABLE.ordinal());
        permissionQuery.setPageSize(-1);
        List<PermissionBO> permissionBoList = this.permissionRepository.queryPermissions(permissionQuery);
        List<KeyValue<Integer, String>> permissionKvs = new ArrayList<>(permissionBoList.size());
        for (PermissionBO permissionBO : permissionBoList) {
            permissionKvs.add(new KeyValue<>(permissionBO.getId().intValue(), permissionBO.getDisplayText()));
        }
        return permissionKvs;
    }
}