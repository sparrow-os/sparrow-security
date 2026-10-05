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
import com.sparrow.security.admin.adapter.assemble.PermissionAssemble;
import com.sparrow.security.admin.domain.bo.PermissionBO;
import com.sparrow.security.admin.protocol.param.PermissionParam;
import com.sparrow.security.admin.protocol.query.PermissionQuery;
import com.sparrow.security.admin.protocol.dto.PermissionDTO;
import com.sparrow.security.admin.domain.service.PermissionService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;
import com.sparrow.security.admin.domain.service.AppService;

import com.sparrow.security.admin.domain.service.MicroServiceService;




@RestController
@RequestMapping("permission")
@Tag(name = "Permission")
public class PermissionController {

    @Inject
    private PermissionService permissionService;

    @Inject
    private PermissionAssemble permissionAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
@Inject
private EnumsContainer businessEnumsContainer;
 @Inject
 private AppService appService;
 @Inject
 private MicroServiceService microServiceService;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<PermissionDTO> search(@RequestBody PermissionQuery permissionQuery) {
        ListRecordTotalBO<PermissionBO> permissionListTotalRecord = this.permissionService.queryPermission(permissionQuery);
        PagerResult<PermissionDTO> pagerResult =this.permissionAssemble.assemblePager(permissionListTotalRecord, permissionQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("permissionType",businessEnumsContainer.getEnums("PermissionType"));
pagerResult.putDictionary("appId",this.appService.getAppKvs());

pagerResult.putDictionary("microServiceId",this.microServiceService.getMicroServiceKvs());

pagerResult.putDictionary("parentId",this.permissionService.getPermissionKvs());

pagerResult.putDictionary("method",businessEnumsContainer.getEnums("HttpMethod"));
pagerResult.putDictionary("target",businessEnumsContainer.getEnums("HttpTarget"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long savePermission(@RequestBody PermissionParam permissionParam) throws BusinessException {
       return  this.permissionService.savePermission(permissionParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public PermissionDTO getPermission(Long permissionId) throws BusinessException {
        PermissionBO permissionBo = permissionService.getPermission(permissionId);
        return this.permissionAssemble.boAssembleDTO(permissionBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deletePermission(@RequestBody Set<Long> ids) throws BusinessException {
       return this.permissionService.deletePermission(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enablePermission(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.permissionService.enablePermission(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disablePermission(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.permissionService.disablePermission(ids);
    }
}