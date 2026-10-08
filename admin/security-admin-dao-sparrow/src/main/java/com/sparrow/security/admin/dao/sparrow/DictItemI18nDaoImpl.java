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
import com.sparrow.security.admin.dao.DictItemI18nDAO;
import com.sparrow.security.admin.dao.query.DictItemI18nDBPagerQuery;
import com.sparrow.security.po.DictItemI18n;
import java.util.List;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class DictItemI18nDaoImpl extends ORMStrategy<DictItemI18n, Long> implements DictItemI18nDAO {
    @Override public List<DictItemI18n> queryDictItemI18ns(DictItemI18nDBPagerQuery pagerDictItemI18nQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerDictItemI18nQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerDictItemI18nQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(DictItemI18n::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(DictItemI18nDBPagerQuery dictItemI18nQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(DictItemI18n::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(dictItemI18nQuery.getStatus()!=null&&dictItemI18nQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(DictItemI18n::getStatus).equal(StatusRecord.valueOf(dictItemI18nQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countDictItemI18n(DictItemI18nDBPagerQuery dictItemI18nPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(dictItemI18nPagerQuery));
        return this.getCount(searchCriteria);
    }
}