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
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.security.po.DictItem;
import com.sparrow.security.admin.protocol.param.DictItemParam;
import com.sparrow.security.admin.protocol.query.DictItemQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.DictItemDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictItemConverter implements Param2POConverter<DictItemParam, DictItem>, PO2BOConverter<DictItemBO, DictItem> {

    @Inject
    private BeanCopier beanCopier;

    public DictItemDBPagerQuery toDbPagerQuery(DictItemQuery dictItemQuery) {
           if (dictItemQuery == null) {
               return new DictItemDBPagerQuery();
           }
           DictItemDBPagerQuery dictItem = new DictItemDBPagerQuery();
           beanCopier.copyProperties(dictItemQuery, dictItem);
           return dictItem;
       }

    @Override public DictItem param2po(DictItemParam param) {
        DictItem dictItem = new DictItem();
        beanCopier.copyProperties(param, dictItem);
        POInitUtils.init(dictItem);

        return dictItem;
    }

    @Override public DictItemBO po2bo(DictItem dictItem) {
        DictItemBO dictItemBO = new DictItemBO();
        beanCopier.copyProperties(dictItem, dictItemBO);
        dictItemBO.setDisplayText(dictItem.getDisplayText());
        return dictItemBO;
    }

    @Override public List<DictItemBO> poList2BoList(List<DictItem> list) {
        List<DictItemBO> dictItemBos = new ArrayList<>(list.size());
        for (DictItem dictItem : list) {
            dictItemBos.add(this.po2bo(dictItem));
        }
        return dictItemBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}