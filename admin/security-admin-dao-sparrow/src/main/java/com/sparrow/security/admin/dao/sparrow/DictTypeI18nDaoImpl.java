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
import com.sparrow.security.admin.dao.DictTypeI18nDAO;
import com.sparrow.security.admin.dao.query.DictTypeI18nDBPagerQuery;
import com.sparrow.security.po.DictTypeI18n;
import java.util.List;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class DictTypeI18nDaoImpl extends ORMStrategy<DictTypeI18n, Long> implements DictTypeI18nDAO {
    @Override public List<DictTypeI18n> queryDictTypeI18ns(DictTypeI18nDBPagerQuery pagerDictTypeI18nQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerDictTypeI18nQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerDictTypeI18nQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(DictTypeI18n::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(DictTypeI18nDBPagerQuery dictTypeI18nQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(DictTypeI18n::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(dictTypeI18nQuery.getStatus()!=null&&dictTypeI18nQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(DictTypeI18n::getStatus).equal(StatusRecord.valueOf(dictTypeI18nQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countDictTypeI18n(DictTypeI18nDBPagerQuery dictTypeI18nPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(dictTypeI18nPagerQuery));
        return this.getCount(searchCriteria);
    }
}