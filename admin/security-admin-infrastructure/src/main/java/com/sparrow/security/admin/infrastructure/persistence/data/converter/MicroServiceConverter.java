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
import com.sparrow.security.admin.domain.bo.MicroServiceBO;
import com.sparrow.security.po.MicroService;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.MicroServiceDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class MicroServiceConverter implements Param2POConverter<MicroServiceParam, MicroService>, PO2BOConverter<MicroServiceBO, MicroService> {

    @Inject
    private BeanCopier beanCopier;

    public MicroServiceDBPagerQuery toDbPagerQuery(MicroServiceQuery microServiceQuery) {
           if (microServiceQuery == null) {
               return new MicroServiceDBPagerQuery();
           }
           MicroServiceDBPagerQuery microService = new MicroServiceDBPagerQuery();
           beanCopier.copyProperties(microServiceQuery, microService);
           return microService;
       }

    @Override public MicroService param2po(MicroServiceParam param) {
        MicroService microService = new MicroService();
        beanCopier.copyProperties(param, microService);
        POInitUtils.init(microService);

        return microService;
    }

    @Override public MicroServiceBO po2bo(MicroService microService) {
        MicroServiceBO microServiceBO = new MicroServiceBO();
        beanCopier.copyProperties(microService, microServiceBO);
        microServiceBO.setDisplayText(microService.getDisplayText());
        return microServiceBO;
    }

    @Override public List<MicroServiceBO> poList2BoList(List<MicroService> list) {
        List<MicroServiceBO> microServiceBos = new ArrayList<>(list.size());
        for (MicroService microService : list) {
            microServiceBos.add(this.po2bo(microService));
        }
        return microServiceBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}