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
package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.PositionDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.PositionConverter;
import com.sparrow.security.po.Position;
import com.sparrow.security.admin.domain.bo.PositionBO;
import com.sparrow.security.admin.protocol.param.PositionParam;
import com.sparrow.security.admin.repository.PositionRepository;
import com.sparrow.security.admin.protocol.query.PositionQuery;

import java.util.*;
import java.util.stream.Collectors;
import jakarta.inject.*;

@Named
public class PositionRepositoryImpl implements PositionRepository {
    @Inject
    private PositionConverter positionConverter;

    @Inject
    private PositionDAO positionDao;

    @Override public Long save(PositionParam positionParam) {
        Position position = this.positionConverter.param2po(positionParam);
        if (position.getId() != null) {
            this.positionDao.update(position);
            return position.getId();
        }
        this.positionDao.insert(position);
        return position.getId();
    }

    @Override public Integer delete(Set<Long> positionIds) {
        return this.positionDao.batchDelete(positionIds);
    }

    @Override public Integer disable(Set<Long> positionIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(positionIds, StatusRecord.DISABLE);
        this.positionConverter.convertStatus(statusCriteria);
        return this.positionDao.changeStatus(statusCriteria);
    }

    @Override public Integer enable(Set<Long> positionIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(positionIds, StatusRecord.ENABLE);
        this.positionConverter.convertStatus(statusCriteria);
        return this.positionDao.changeStatus(statusCriteria);
    }

    @Override public PositionBO getPosition(Long positionId) {
        Position position = this.positionDao.getEntity(positionId);
        return this.positionConverter.po2bo(position);
    }

    @Override public List<PositionBO> queryPositions(PositionQuery positionQuery) {
        List<Position> positionList = this.positionDao.queryPositions(this.positionConverter.toDbPagerQuery(positionQuery));
        return this.positionConverter.poList2BoList(positionList);
    }

    @Override public Long getPositionCount(PositionQuery positionQuery) {
        return this.positionDao.countPosition(this.positionConverter.toDbPagerQuery(positionQuery));
    }

    
}