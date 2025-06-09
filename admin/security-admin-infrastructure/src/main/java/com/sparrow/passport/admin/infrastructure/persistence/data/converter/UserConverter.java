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
package com.sparrow.passport.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.passport.admin.domain.bo.UserBO;
import com.sparrow.passport.po.User;
import com.sparrow.passport.admin.protocol.param.UserParam;
import com.sparrow.passport.admin.protocol.query.UserQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.passport.admin.dao.query.UserDBPagerQuery;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class UserConverter implements Param2POConverter<UserParam, User>, PO2BOConverter<UserBO, User> {
   
    public UserDBPagerQuery toDbPagerQuery(UserQuery userQuery) {
           if (userQuery == null) {
               return new UserDBPagerQuery();
           }
           UserDBPagerQuery UserDBPagerQuery = new UserDBPagerQuery();
           BeanUtility.copyProperties(userQuery, UserDBPagerQuery);
           return UserDBPagerQuery;
       }

    @Override public User param2po(UserParam param) {
        User user = new User();
        BeanUtility.copyProperties(param, user);

        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        user.setCreateUserId(0L);
        user.setModifiedUserId(0L);
        user.setStatus(StatusRecord.ENABLE);

        user.setCreateUserName("");
        user.setModifiedUserName("");
        return user;
    }

    @Override public UserBO po2bo(User user) {
        UserBO userBO = new UserBO();
        BeanUtility.copyProperties(user, userBO);
        return userBO;
    }

    @Override public List<UserBO> poList2BoList(List<User> list) {
        List<UserBO> userBos = new ArrayList<>(list.size());
        for (User user : list) {
            userBos.add(this.po2bo(user));
        }
        return userBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            statusCriteria.setModifiedUserName("harry");
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(1L);
    }
}