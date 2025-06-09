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
package com.sparrow.passport.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.passport.admin.domain.bo.UserBO;
import com.sparrow.passport.admin.repository.UserRepository;
import com.sparrow.passport.admin.protocol.param.UserParam;
import com.sparrow.passport.admin.protocol.query.UserQuery;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {
    @Inject
    private UserRepository userRepository;

    private void validateSaveUser(UserParam userParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(userParam.getName()), SecurityAdminError.NAME_IS_EMPTY, UserSuffix.name);
    }

    public Long saveUser(UserParam userParam) throws BusinessException {
        this.validateSaveUser(userParam);
        return this.userRepository.save(userParam);
    }

    public Integer deleteUser(String userIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(userIds), SecurityAdminError.User_ID_IS_EMPTY);
        return this.userRepository.delete(userIds);
    }

    public Integer enableUser(String userIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(userIds), SecurityAdminError.User_ID_IS_EMPTY);
        return this.userRepository.enable(userIds);
    }

    public Integer disableUser(String userIds) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(userIds), SecurityAdminError.User_ID_IS_EMPTY);
        return this.userRepository.disable(userIds);
    }

    public ListRecordTotalBO<UserBO> queryAllUser() {
        return queryUser(null);
    }

    public ListRecordTotalBO<UserBO> queryUser(UserQuery userQuery) {
        Long totalRecord = this.userRepository.getUserCount(userQuery);
        List<UserBO> userBoList = null;
        if (totalRecord > 0) {
            userBoList = this.userRepository.queryUsers(userQuery);
        }
        return new ListRecordTotalBO<>(userBoList, totalRecord);
    }

    public UserBO getUser(Long userId) throws BusinessException {
        //Asserts.isTrue(userId == null, SecurityAdminError.user_IS_EMPTY);
        return this.userRepository.getUser(userId);
    }
}