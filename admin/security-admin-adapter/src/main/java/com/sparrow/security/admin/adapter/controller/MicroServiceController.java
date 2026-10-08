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
import com.sparrow.security.admin.adapter.assemble.MicroServiceAssemble;
import com.sparrow.security.admin.domain.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.security.admin.protocol.dto.MicroServiceDTO;
import com.sparrow.security.admin.domain.service.MicroServiceService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;
import com.sparrow.security.admin.domain.service.AppService;




@RestController
@RequestMapping("micro/service")
@Tag(name = "MicroService")
public class MicroServiceController {

    @Inject
    private MicroServiceService microServiceService;

    @Inject
    private MicroServiceAssemble microServiceAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
 @Inject
 private AppService appService;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<MicroServiceDTO> search(@RequestBody MicroServiceQuery microServiceQuery) {
        ListRecordTotalBO<MicroServiceBO> microServiceListTotalRecord = this.microServiceService.queryMicroService(microServiceQuery);
        PagerResult<MicroServiceDTO> pagerResult =this.microServiceAssemble.assemblePager(microServiceListTotalRecord, microServiceQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("appId",this.appService.getAppKvs());

        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveMicroService(@RequestBody MicroServiceParam microServiceParam) throws BusinessException {
       return  this.microServiceService.saveMicroService(microServiceParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public MicroServiceDTO getMicroService(Long microServiceId) throws BusinessException {
        MicroServiceBO microServiceBo = microServiceService.getMicroService(microServiceId);
        return this.microServiceAssemble.boAssembleDTO(microServiceBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteMicroService(@RequestBody Set<Long> ids) throws BusinessException {
       return this.microServiceService.deleteMicroService(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableMicroService(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.microServiceService.enableMicroService(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableMicroService(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.microServiceService.disableMicroService(ids);
    }
}