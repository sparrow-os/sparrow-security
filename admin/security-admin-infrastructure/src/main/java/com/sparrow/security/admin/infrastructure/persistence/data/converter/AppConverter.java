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
import com.sparrow.security.admin.domain.bo.AppBO;
import com.sparrow.security.po.App;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.AppDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class AppConverter implements Param2POConverter<AppParam, App>, PO2BOConverter<AppBO, App> {

    @Inject
    private BeanCopier beanCopier;

    public AppDBPagerQuery toDbPagerQuery(AppQuery appQuery) {
           if (appQuery == null) {
               return new AppDBPagerQuery();
           }
           AppDBPagerQuery app = new AppDBPagerQuery();
           beanCopier.copyProperties(appQuery, app);
           return app;
       }

    @Override public App param2po(AppParam param) {
        App app = new App();
        beanCopier.copyProperties(param, app);
        POInitUtils.init(app);

        return app;
    }

    @Override public AppBO po2bo(App app) {
        AppBO appBO = new AppBO();
        beanCopier.copyProperties(app, appBO);
        appBO.setDisplayText(app.getDisplayText());
        return appBO;
    }

    @Override public List<AppBO> poList2BoList(List<App> list) {
        List<AppBO> appBos = new ArrayList<>(list.size());
        for (App app : list) {
            appBos.add(this.po2bo(app));
        }
        return appBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}