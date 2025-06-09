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

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.SparrowExampleBO;
import com.sparrow.security.po.SparrowExample;
import com.sparrow.security.admin.protocol.param.SparrowExampleParam;
import com.sparrow.security.admin.protocol.query.SparrowExampleQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.SparrowExampleDBPagerQuery;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class SparrowExampleConverter implements Param2POConverter<SparrowExampleParam, SparrowExample>, PO2BOConverter<SparrowExampleBO, SparrowExample> {
   
    public SparrowExampleDBPagerQuery toDbPagerQuery(SparrowExampleQuery sparrowExampleQuery) {
           if (sparrowExampleQuery == null) {
               return new SparrowExampleDBPagerQuery();
           }
           SparrowExampleDBPagerQuery SparrowExampleDBPagerQuery = new SparrowExampleDBPagerQuery();
           BeanUtility.copyProperties(sparrowExampleQuery, SparrowExampleDBPagerQuery);
           return SparrowExampleDBPagerQuery;
       }

    @Override public SparrowExample param2po(SparrowExampleParam param) {
        SparrowExample sparrowExample = new SparrowExample();
        BeanUtility.copyProperties(param, sparrowExample);

        sparrowExample.setGmtCreate(System.currentTimeMillis());
        sparrowExample.setGmtModified(sparrowExample.getGmtCreate());
        sparrowExample.setCreateUserId(0L);
        sparrowExample.setModifiedUserId(0L);
        sparrowExample.setStatus(StatusRecord.ENABLE);

        sparrowExample.setCreateUserName("");
        sparrowExample.setModifiedUserName("");
        return sparrowExample;
    }

    @Override public SparrowExampleBO po2bo(SparrowExample sparrowExample) {
        SparrowExampleBO sparrowExampleBO = new SparrowExampleBO();
        BeanUtility.copyProperties(sparrowExample, sparrowExampleBO);
        return sparrowExampleBO;
    }

    @Override public List<SparrowExampleBO> poList2BoList(List<SparrowExample> list) {
        List<SparrowExampleBO> sparrowExampleBos = new ArrayList<>(list.size());
        for (SparrowExample sparrowExample : list) {
            sparrowExampleBos.add(this.po2bo(sparrowExample));
        }
        return sparrowExampleBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            statusCriteria.setModifiedUserName("harry");
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(1L);
    }
}