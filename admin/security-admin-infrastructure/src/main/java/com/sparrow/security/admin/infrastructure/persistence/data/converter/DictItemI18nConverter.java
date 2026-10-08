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
import com.sparrow.security.admin.domain.bo.DictItemI18nBO;
import com.sparrow.security.po.DictItemI18n;
import com.sparrow.security.admin.protocol.param.DictItemI18nParam;
import com.sparrow.security.admin.protocol.query.DictItemI18nQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.DictItemI18nDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictItemI18nConverter implements Param2POConverter<DictItemI18nParam, DictItemI18n>, PO2BOConverter<DictItemI18nBO, DictItemI18n> {

    @Inject
    private BeanCopier beanCopier;

    public DictItemI18nDBPagerQuery toDbPagerQuery(DictItemI18nQuery dictItemI18nQuery) {
           if (dictItemI18nQuery == null) {
               return new DictItemI18nDBPagerQuery();
           }
           DictItemI18nDBPagerQuery dictItemI18n = new DictItemI18nDBPagerQuery();
           beanCopier.copyProperties(dictItemI18nQuery, dictItemI18n);
           return dictItemI18n;
       }

    @Override public DictItemI18n param2po(DictItemI18nParam param) {
        DictItemI18n dictItemI18n = new DictItemI18n();
        beanCopier.copyProperties(param, dictItemI18n);
        POInitUtils.init(dictItemI18n);

        return dictItemI18n;
    }

    @Override public DictItemI18nBO po2bo(DictItemI18n dictItemI18n) {
        DictItemI18nBO dictItemI18nBO = new DictItemI18nBO();
        beanCopier.copyProperties(dictItemI18n, dictItemI18nBO);
        
        return dictItemI18nBO;
    }

    @Override public List<DictItemI18nBO> poList2BoList(List<DictItemI18n> list) {
        List<DictItemI18nBO> dictItemI18nBos = new ArrayList<>(list.size());
        for (DictItemI18n dictItemI18n : list) {
            dictItemI18nBos.add(this.po2bo(dictItemI18n));
        }
        return dictItemI18nBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}