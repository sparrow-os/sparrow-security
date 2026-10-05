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

package com.sparrow.security.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.*;
import java.util.*;
import jakarta.inject.*;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.domain.bo.PositionBO;
import com.sparrow.security.admin.repository.PositionRepository;
import com.sparrow.security.admin.protocol.param.PositionParam;
import com.sparrow.security.admin.protocol.query.PositionQuery;
import com.sparrow.utility.CollectionsUtility;


@Named
public class PositionService {
    @Inject
    private PositionRepository positionRepository;

    private void validateSavePosition(PositionParam positionParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(positionParam.getName()), SecurityAdminError.NAME_IS_EMPTY, PositionSuffix.name);
    }

    public Long savePosition(PositionParam positionParam) throws BusinessException {
        this.validateSavePosition(positionParam);
        return this.positionRepository.save(positionParam);
    }

    public Integer deletePosition(Set<Long> positionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(positionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.positionRepository.delete(positionIds);
    }

    public Integer enablePosition(Set<Long> positionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(positionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.positionRepository.enable(positionIds);
    }

    public Integer disablePosition(Set<Long> positionIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(positionIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.positionRepository.disable(positionIds);
    }

    public ListRecordTotalBO<PositionBO> queryAllPosition() {
        return queryPosition(null);
    }

    public ListRecordTotalBO<PositionBO> queryPosition(PositionQuery positionQuery) {
        Long totalRecord = this.positionRepository.getPositionCount(positionQuery);
        List<PositionBO> positionBoList = null;
        if (totalRecord > 0) {
            positionBoList = this.positionRepository.queryPositions(positionQuery);
        }
        return new ListRecordTotalBO<>(positionBoList, totalRecord);
    }

    public PositionBO getPosition(Long positionId) throws BusinessException {
         Asserts.isTrue(positionId==null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.positionRepository.getPosition(positionId);
    }
    public List<KeyValue<Integer, String>> getPositionKvs() {
        PositionQuery positionQuery = new PositionQuery();
        positionQuery.setStatus(StatusRecord.ENABLE.ordinal());
        positionQuery.setPageSize(-1);
        List<PositionBO> positionBoList = this.positionRepository.queryPositions(positionQuery);
        List<KeyValue<Integer, String>> positionKvs = new ArrayList<>(positionBoList.size());
        for (PositionBO positionBO : positionBoList) {
            positionKvs.add(new KeyValue<>(positionBO.getId().intValue(), positionBO.getDisplayText()));
        }
        return positionKvs;
    }
}