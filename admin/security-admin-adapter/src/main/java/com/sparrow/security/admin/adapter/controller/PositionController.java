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
package com.sparrow.security.admin.adapter.controller;

import com.sparrow.protocol.*;
import java.util.*;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.security.admin.adapter.assemble.PositionAssemble;
import com.sparrow.security.admin.domain.bo.PositionBO;
import com.sparrow.security.admin.protocol.param.PositionParam;
import com.sparrow.security.admin.protocol.query.PositionQuery;
import com.sparrow.security.admin.protocol.dto.PositionDTO;
import com.sparrow.security.admin.domain.service.PositionService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;

import com.sparrow.security.admin.domain.service.OrganizationService;




@RestController
@RequestMapping("position")
@Tag(name = "Position")
public class PositionController {

    @Inject
    private PositionService positionService;

    @Inject
    private PositionAssemble positionAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
 @Inject
 private OrganizationService organizationService;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<PositionDTO> search(@RequestBody PositionQuery positionQuery) {
        
        ListRecordTotalBO<PositionBO> positionListTotalRecord = this.positionService.queryPosition(positionQuery);
        PagerResult<PositionDTO> pagerResult =this.positionAssemble.assemblePager(positionListTotalRecord, positionQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("organizationId",this.organizationService.getOrganizationKvs());

        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long savePosition(@RequestBody PositionParam positionParam) throws BusinessException {
       return  this.positionService.savePosition(positionParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public PositionDTO getPosition(Long positionId) throws BusinessException {
        PositionBO positionBo = positionService.getPosition(positionId);
        return this.positionAssemble.boAssembleDTO(positionBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deletePosition(@RequestBody Set<Long> ids) throws BusinessException {
       return this.positionService.deletePosition(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enablePosition(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.positionService.enablePosition(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disablePosition(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.positionService.disablePosition(ids);
    }
}