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
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.security.po.DictTypeI18n;
import com.sparrow.security.admin.protocol.param.DictTypeI18nParam;
import com.sparrow.security.admin.protocol.query.DictTypeI18nQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.DictTypeI18nDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictTypeI18nConverter implements Param2POConverter<DictTypeI18nParam, DictTypeI18n>, PO2BOConverter<DictTypeI18nBO, DictTypeI18n> {

    @Inject
    private BeanCopier beanCopier;

    public DictTypeI18nDBPagerQuery toDbPagerQuery(DictTypeI18nQuery dictTypeI18nQuery) {
           if (dictTypeI18nQuery == null) {
               return new DictTypeI18nDBPagerQuery();
           }
           DictTypeI18nDBPagerQuery dictTypeI18n = new DictTypeI18nDBPagerQuery();
           beanCopier.copyProperties(dictTypeI18nQuery, dictTypeI18n);
           return dictTypeI18n;
       }

    @Override public DictTypeI18n param2po(DictTypeI18nParam param) {
        DictTypeI18n dictTypeI18n = new DictTypeI18n();
        beanCopier.copyProperties(param, dictTypeI18n);
        POInitUtils.init(dictTypeI18n);

        return dictTypeI18n;
    }

    @Override public DictTypeI18nBO po2bo(DictTypeI18n dictTypeI18n) {
        DictTypeI18nBO dictTypeI18nBO = new DictTypeI18nBO();
        beanCopier.copyProperties(dictTypeI18n, dictTypeI18nBO);
        
        return dictTypeI18nBO;
    }

    @Override public List<DictTypeI18nBO> poList2BoList(List<DictTypeI18n> list) {
        List<DictTypeI18nBO> dictTypeI18nBos = new ArrayList<>(list.size());
        for (DictTypeI18n dictTypeI18n : list) {
            dictTypeI18nBos.add(this.po2bo(dictTypeI18n));
        }
        return dictTypeI18nBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}