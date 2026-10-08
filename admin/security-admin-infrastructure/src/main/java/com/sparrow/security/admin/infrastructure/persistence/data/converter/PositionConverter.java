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
import com.sparrow.security.admin.domain.bo.PositionBO;
import com.sparrow.security.po.Position;
import com.sparrow.security.admin.protocol.param.PositionParam;
import com.sparrow.security.admin.protocol.query.PositionQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.security.admin.dao.query.PositionDBPagerQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.*;
import com.sparrow.protocol.BeanCopier;


@Named
public class PositionConverter implements Param2POConverter<PositionParam, Position>, PO2BOConverter<PositionBO, Position> {

    @Inject
    private BeanCopier beanCopier;

    public PositionDBPagerQuery toDbPagerQuery(PositionQuery positionQuery) {
           if (positionQuery == null) {
               return new PositionDBPagerQuery();
           }
           PositionDBPagerQuery position = new PositionDBPagerQuery();
           beanCopier.copyProperties(positionQuery, position);
           return position;
       }

    @Override public Position param2po(PositionParam param) {
        Position position = new Position();
        beanCopier.copyProperties(param, position);
        POInitUtils.init(position);

        return position;
    }

    @Override public PositionBO po2bo(Position position) {
        PositionBO positionBO = new PositionBO();
        beanCopier.copyProperties(position, positionBO);
        positionBO.setDisplayText(position.getDisplayText());
        return positionBO;
    }

    @Override public List<PositionBO> poList2BoList(List<Position> list) {
        List<PositionBO> positionBos = new ArrayList<>(list.size());
        for (Position position : list) {
            positionBos.add(this.po2bo(position));
        }
        return positionBos;
    }

    public void convertStatus(StatusCriteria statusCriteria){
            LoginUser loginUser = SessionContext.getLoginUser();
            statusCriteria.setModifiedUserName(loginUser.getUserName());
            statusCriteria.setGmtModified(System.currentTimeMillis());
            statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}