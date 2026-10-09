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
import com.sparrow.security.admin.adapter.assemble.UserGroupAssemble;
import com.sparrow.security.admin.domain.bo.UserGroupBO;
import com.sparrow.security.admin.protocol.param.UserGroupParam;
import com.sparrow.security.admin.protocol.query.UserGroupQuery;
import com.sparrow.security.admin.protocol.dto.UserGroupDTO;
import com.sparrow.security.admin.domain.service.UserGroupService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("user/group")
@Tag(name = "UserGroup")
public class UserGroupController {

    @Inject
    private UserGroupService userGroupService;

    @Inject
    private UserGroupAssemble userGroupAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<UserGroupDTO> search(@RequestBody UserGroupQuery userGroupQuery) {
        
        ListRecordTotalBO<UserGroupBO> userGroupListTotalRecord = this.userGroupService.queryUserGroup(userGroupQuery);
        PagerResult<UserGroupDTO> pagerResult =this.userGroupAssemble.assemblePager(userGroupListTotalRecord, userGroupQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveUserGroup(@RequestBody UserGroupParam userGroupParam) throws BusinessException {
       return  this.userGroupService.saveUserGroup(userGroupParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public UserGroupDTO getUserGroup(Long userGroupId) throws BusinessException {
        UserGroupBO userGroupBo = userGroupService.getUserGroup(userGroupId);
        return this.userGroupAssemble.boAssembleDTO(userGroupBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteUserGroup(@RequestBody Set<Long> ids) throws BusinessException {
       return this.userGroupService.deleteUserGroup(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableUserGroup(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.userGroupService.enableUserGroup(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableUserGroup(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.userGroupService.disableUserGroup(ids);
    }
}