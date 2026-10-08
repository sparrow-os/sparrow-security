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
import com.sparrow.security.admin.dao.DictTypeDAO;
import com.sparrow.security.admin.dao.query.DictTypeDBPagerQuery;
import com.sparrow.security.po.DictType;
import java.util.List;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class DictTypeDaoImpl extends ORMStrategy<DictType, Long> implements DictTypeDAO {
    @Override public List<DictType> queryDictTypes(DictTypeDBPagerQuery pagerDictTypeQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerDictTypeQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerDictTypeQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(DictType::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(DictTypeDBPagerQuery dictTypeQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(DictType::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(dictTypeQuery.getStatus()!=null&&dictTypeQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(DictType::getStatus).equal(StatusRecord.valueOf(dictTypeQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countDictType(DictTypeDBPagerQuery dictTypePagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(dictTypePagerQuery));
        return this.getCount(searchCriteria);
    }
}