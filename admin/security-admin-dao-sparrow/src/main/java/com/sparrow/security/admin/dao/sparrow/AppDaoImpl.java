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
package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.*;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.admin.dao.query.AppDBPagerQuery;
import com.sparrow.security.po.App;
import java.util.*;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class AppDaoImpl extends ORMStrategy<App, Long> implements AppDAO {
    @Override public List<App> queryApps(AppDBPagerQuery pagerAppQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerAppQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerAppQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(App::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(AppDBPagerQuery appQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(App::getCode).equal(appQuery.getCode())).and(Criteria.field(App::getName).equal(appQuery.getName())).and(Criteria.field(App::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(appQuery.getStatus()!=null&&appQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(App::getStatus).equal(StatusRecord.valueOf(appQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countApp(AppDBPagerQuery appPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(appPagerQuery));
        return this.getCount(searchCriteria);
    }


     
}