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
package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.LoginUser;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.support.converter.POInitUtils;
import com.sparrow.security.admin.domain.bo.UserGroupBO;
import com.sparrow.security.po.UserGroup;
import com.sparrow.security.admin.protocol.param.UserGroupParam;
import com.sparrow.security.admin.protocol.query.UserGroupQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.UserGroupDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class UserGroupConverter implements Param2POConverter<UserGroupParam, UserGroup>, PO2BOConverter<UserGroupBO, UserGroup> {

    @Inject
    private BeanCopier beanCopier;

    public UserGroupDBPagerQuery toDbPagerQuery(UserGroupQuery userGroupQuery) {
           if (userGroupQuery == null) {
               return new UserGroupDBPagerQuery();
           }
           UserGroupDBPagerQuery userGroup = new UserGroupDBPagerQuery();
           beanCopier.copyProperties(userGroupQuery, userGroup);
           return userGroup;
       }

    @Override public UserGroup param2po(UserGroupParam param) {
        UserGroup userGroup = new UserGroup();
        beanCopier.copyProperties(param, userGroup);
        POInitUtils.init(userGroup);

        return userGroup;
    }

    @Override public UserGroupBO po2bo(UserGroup userGroup) {
        UserGroupBO userGroupBO = new UserGroupBO();
        beanCopier.copyProperties(userGroup, userGroupBO);
        
        return userGroupBO;
    }

    @Override public List<UserGroupBO> poList2BoList(List<UserGroup> list) {
        List<UserGroupBO> userGroupBos = new ArrayList<>(list.size());
        for (UserGroup userGroup : list) {
            userGroupBos.add(this.po2bo(userGroup));
        }
        return userGroupBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}