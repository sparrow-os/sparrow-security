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
import com.sparrow.security.admin.adapter.assemble.AppAssemble;
import com.sparrow.security.admin.domain.bo.AppBO;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.security.admin.protocol.dto.AppDTO;
import com.sparrow.security.admin.domain.service.AppService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("app")
@Tag(name = "App")
public class AppController {

    @Inject
    private AppService appService;

    @Inject
    private AppAssemble appAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<AppDTO> search(@RequestBody AppQuery appQuery) {
        ListRecordTotalBO<AppBO> appListTotalRecord = this.appService.queryApp(appQuery);
        PagerResult<AppDTO> pagerResult =this.appAssemble.assemblePager(appListTotalRecord, appQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveApp(@RequestBody AppParam appParam) throws BusinessException {
       return  this.appService.saveApp(appParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public AppDTO getApp(Long appId) throws BusinessException {
        AppBO appBo = appService.getApp(appId);
        return this.appAssemble.boAssembleDTO(appBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteApp(@RequestBody Set<Long> ids) throws BusinessException {
       return this.appService.deleteApp(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableApp(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.appService.enableApp(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableApp(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.appService.disableApp(ids);
    }
}