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
import com.sparrow.security.admin.domain.bo.DictTypeBO;
import com.sparrow.security.po.DictType;
import com.sparrow.security.admin.protocol.param.DictTypeParam;
import com.sparrow.security.admin.protocol.query.DictTypeQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.DictTypeDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class DictTypeConverter implements Param2POConverter<DictTypeParam, DictType>, PO2BOConverter<DictTypeBO, DictType> {

    @Inject
    private BeanCopier beanCopier;

    public DictTypeDBPagerQuery toDbPagerQuery(DictTypeQuery dictTypeQuery) {
           if (dictTypeQuery == null) {
               return new DictTypeDBPagerQuery();
           }
           DictTypeDBPagerQuery dictType = new DictTypeDBPagerQuery();
           beanCopier.copyProperties(dictTypeQuery, dictType);
           return dictType;
       }

    @Override public DictType param2po(DictTypeParam param) {
        DictType dictType = new DictType();
        beanCopier.copyProperties(param, dictType);
        POInitUtils.init(dictType);

        return dictType;
    }

    @Override public DictTypeBO po2bo(DictType dictType) {
        DictTypeBO dictTypeBO = new DictTypeBO();
        beanCopier.copyProperties(dictType, dictTypeBO);
        dictTypeBO.setDisplayText(dictType.getDisplayText());
        return dictTypeBO;
    }

    @Override public List<DictTypeBO> poList2BoList(List<DictType> list) {
        List<DictTypeBO> dictTypeBos = new ArrayList<>(list.size());
        for (DictType dictType : list) {
            dictTypeBos.add(this.po2bo(dictType));
        }
        return dictTypeBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}