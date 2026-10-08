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
import com.sparrow.security.admin.domain.bo.UserGroupBO;
import com.sparrow.protocol.pager.SimplePager;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.security.admin.repository.UserGroupRepository;
import com.sparrow.security.admin.protocol.param.UserGroupParam;
import com.sparrow.security.admin.protocol.query.UserGroupQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class UserGroupService {
    @Inject
    private UserGroupRepository userGroupRepository;

    private void validateSaveUserGroup(UserGroupParam userGroupParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(userGroupParam.getName()), SecurityAdminError.NAME_IS_EMPTY, UserGroupSuffix.name);
    }

    public Long saveUserGroup(UserGroupParam userGroupParam) throws BusinessException {
        this.validateSaveUserGroup(userGroupParam);
        return this.userGroupRepository.save(userGroupParam);
    }

    public Integer deleteUserGroup(Set<Long> userGroupIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(userGroupIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.userGroupRepository.delete(userGroupIds);
    }

    public Integer enableUserGroup(Set<Long> userGroupIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(userGroupIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.userGroupRepository.enable(userGroupIds);
    }

    public Integer disableUserGroup(Set<Long> userGroupIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(userGroupIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.userGroupRepository.disable(userGroupIds);
    }

    public ListRecordTotalBO<UserGroupBO> queryAllUserGroup() {
        return queryUserGroup(null);
    }

    
    
        public ListRecordTotalBO<UserGroupBO> queryUserGroup(UserGroupQuery userGroupQuery) {
            Long totalRecord = this.userGroupRepository.getUserGroupCount(userGroupQuery);
            List<UserGroupBO> userGroupBoList = null;
            if (totalRecord > 0) {
                userGroupBoList = this.userGroupRepository.queryUserGroups(userGroupQuery);
            }
            return new ListRecordTotalBO<>(userGroupBoList, totalRecord);
        }
    





    public UserGroupBO getUserGroup(Long userGroupId) throws BusinessException {
         Asserts.isTrue(userGroupId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.userGroupRepository.getUserGroup(userGroupId);
    }
    
}