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
import com.sparrow.security.admin.adapter.assemble.RoleAssemble;
import com.sparrow.security.admin.domain.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import com.sparrow.security.admin.protocol.dto.RoleDTO;
import com.sparrow.security.admin.domain.service.RoleService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("role")
@Tag(name = "Role")
public class RoleController {

    @Inject
    private RoleService roleService;

    @Inject
    private RoleAssemble roleAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<RoleDTO> search(@RequestBody RoleQuery roleQuery) {
        
        ListRecordTotalBO<RoleBO> roleListTotalRecord = this.roleService.queryRole(roleQuery);
        PagerResult<RoleDTO> pagerResult =this.roleAssemble.assemblePager(roleListTotalRecord, roleQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveRole(@RequestBody RoleParam roleParam) throws BusinessException {
       return  this.roleService.saveRole(roleParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public RoleDTO getRole(Long roleId) throws BusinessException {
        RoleBO roleBo = roleService.getRole(roleId);
        return this.roleAssemble.boAssembleDTO(roleBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteRole(@RequestBody Set<Long> ids) throws BusinessException {
       return this.roleService.deleteRole(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableRole(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.roleService.enableRole(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableRole(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.roleService.disableRole(ids);
    }
}