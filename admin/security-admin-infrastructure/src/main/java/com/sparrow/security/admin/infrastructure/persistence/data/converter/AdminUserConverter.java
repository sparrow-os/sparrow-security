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
import com.sparrow.security.admin.domain.bo.AdminUserBO;
import com.sparrow.security.po.AdminUser;
import com.sparrow.security.admin.protocol.param.AdminUserParam;
import com.sparrow.security.admin.protocol.query.AdminUserQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.AdminUserDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class AdminUserConverter implements Param2POConverter<AdminUserParam, AdminUser>, PO2BOConverter<AdminUserBO, AdminUser> {

    @Inject
    private BeanCopier beanCopier;

    public AdminUserDBPagerQuery toDbPagerQuery(AdminUserQuery adminUserQuery) {
           if (adminUserQuery == null) {
               return new AdminUserDBPagerQuery();
           }
           AdminUserDBPagerQuery adminUser = new AdminUserDBPagerQuery();
           beanCopier.copyProperties(adminUserQuery, adminUser);
           return adminUser;
       }

    @Override public AdminUser param2po(AdminUserParam param) {
        AdminUser adminUser = new AdminUser();
        beanCopier.copyProperties(param, adminUser);
        POInitUtils.init(adminUser);

        return adminUser;
    }

    @Override public AdminUserBO po2bo(AdminUser adminUser) {
        AdminUserBO adminUserBO = new AdminUserBO();
        beanCopier.copyProperties(adminUser, adminUserBO);
        
        return adminUserBO;
    }

    @Override public List<AdminUserBO> poList2BoList(List<AdminUser> list) {
        List<AdminUserBO> adminUserBos = new ArrayList<>(list.size());
        for (AdminUser adminUser : list) {
            adminUserBos.add(this.po2bo(adminUser));
        }
        return adminUserBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}