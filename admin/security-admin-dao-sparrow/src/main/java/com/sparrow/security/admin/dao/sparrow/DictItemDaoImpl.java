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
import com.sparrow.security.admin.dao.DictItemDAO;
import com.sparrow.security.admin.dao.query.DictItemDBPagerQuery;
import com.sparrow.security.po.DictItem;
import java.util.*;
import jakarta.inject.Named;
import com.sparrow.protocol.*;
import com.sparrow.context.SessionContext;
import com.sparrow.protocol.enums.StatusRecord;


@Named
public class DictItemDaoImpl extends ORMStrategy<DictItem, Long> implements DictItemDAO {
    @Override public List<DictItem> queryDictItems(DictItemDBPagerQuery pagerDictItemQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerDictItemQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerDictItemQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(DictItem::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(DictItemDBPagerQuery dictItemQuery) {
        BooleanCriteria booleanCriteria= BooleanCriteria.criteria(Criteria.field(DictItem::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));if(dictItemQuery.getParentId()!=null&&dictItemQuery.getParentId()>=0) {booleanCriteria.and(Criteria.field(DictItem::getParentId).equal(dictItemQuery.getParentId()));}if(dictItemQuery.getDictTypeId()!=null&&dictItemQuery.getDictTypeId()>=0) {booleanCriteria.and(Criteria.field(DictItem::getDictTypeId).equal(dictItemQuery.getDictTypeId()));}if(dictItemQuery.getStatus()!=null&&dictItemQuery.getStatus()>=0) {booleanCriteria.and(Criteria.field(DictItem::getStatus).equal(StatusRecord.valueOf(dictItemQuery.getStatus())));} return booleanCriteria;
    }

    @Override public Long countDictItem(DictItemDBPagerQuery dictItemPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(dictItemPagerQuery));
        return this.getCount(searchCriteria);
    }


     
                @Override
                public List<DictItem> queryChildren(DictItemDBPagerQuery dictItemPagerQuery) {
                    SearchCriteria searchCriteria = new SearchCriteria();
                    searchCriteria.setWhere(this.generateCriteria(dictItemPagerQuery));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(DictItem::getSort));
                    searchCriteria.addOrderCriteria(OrderCriteria.asc(DictItem::getId));
                    return this.getList(searchCriteria);
                }

            @Override
            public Set<Long> getParentIdsHavingChildren(Collection<Long> parentIds,StatusRecord statusRecord) {
                if (parentIds == null || parentIds.isEmpty()) {
                    return Collections.emptySet();
                }
                SearchCriteria searchCriteria = new SearchCriteria();
                CriteriaField parentIdField = Criteria.field(DictItem::getParentId).getField();
                searchCriteria.setFields(parentIdField.getAlias() + "." + parentIdField.getName());
                searchCriteria.setDistinct(true);

                BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field(DictItem::getParentId).in(parentIds));
                        if (statusRecord != null) {
                            booleanCriteria.and(Criteria.field(DictItem::getStatus).equal(statusRecord));
                        }

                searchCriteria.setWhere(booleanCriteria);

                Set<Object> rawParentIds = this.firstList(searchCriteria);
                Set<Long> parentIdsWithChildren = new HashSet<>(rawParentIds.size());
                for (Object rawParentId : rawParentIds) {
                    parentIdsWithChildren.add(((Number) rawParentId).longValue());
                }
                return parentIdsWithChildren;
            }
        
}