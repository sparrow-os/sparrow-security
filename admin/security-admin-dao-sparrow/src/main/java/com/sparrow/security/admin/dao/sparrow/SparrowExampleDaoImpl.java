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

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.SparrowExampleDAO;
import com.sparrow.security.admin.dao.query.SparrowExampleDBPagerQuery;
import com.sparrow.security.po.SparrowExample;
import java.util.List;
import javax.inject.Named;

@Named
public class SparrowExampleDaoImpl extends ORMStrategy<SparrowExample, Long> implements SparrowExampleDAO {
    @Override public List<SparrowExample> querySparrowExamples(SparrowExampleDBPagerQuery pagerSparrowExampleQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerSparrowExampleQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerSparrowExampleQuery));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(SparrowExampleDBPagerQuery countSparrowExampleQuery) {
        Long startTime=null;
        if(countSparrowExampleQuery.getBeginDate()!=null){
            startTime=countSparrowExampleQuery.getBeginDate().getTime();
        }

        Long endTime=null;
        if(countSparrowExampleQuery.getEndDate()!=null){
            endTime=countSparrowExampleQuery.getEndDate().getTime();
        }

        return BooleanCriteria.criteria(
            Criteria.field("sparrowExample.name").equal(countSparrowExampleQuery.getName()))
            .and(Criteria.field("sparrowExample.createTime").greaterThan(startTime))
            .and(Criteria.field("sparrowExample.createTime").lessThan(endTime));
    }

    @Override public Long countSparrowExample(SparrowExampleDBPagerQuery sparrowExamplePagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(sparrowExamplePagerQuery));
        return this.getCount(searchCriteria);
    }
}