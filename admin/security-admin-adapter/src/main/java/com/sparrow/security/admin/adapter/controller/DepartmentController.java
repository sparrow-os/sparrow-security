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

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.security.admin.adapter.assemble.DepartmentAssemble;
import com.sparrow.security.admin.domain.bo.DepartmentBO;
import com.sparrow.security.admin.domain.service.DepartmentService;
import com.sparrow.security.admin.protocol.dto.DepartmentDTO;
import com.sparrow.security.admin.protocol.param.DepartmentParam;
import com.sparrow.security.admin.protocol.query.DepartmentQuery;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("department")
@Tag(name = "Department")
public class DepartmentController {

    @Inject
    private DepartmentService departmentService;

    @Inject
    private DepartmentAssemble departmentAssemble;

    @Inject
    private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method = "搜索")
    public PagerResult<DepartmentDTO> search(@RequestBody DepartmentQuery departmentQuery) {
        ListRecordTotalBO<DepartmentBO> departmentListTotalRecord = this.departmentService.queryDepartment(departmentQuery);
        PagerResult<DepartmentDTO> pagerResult = this.departmentAssemble.assemblePager(departmentListTotalRecord, departmentQuery);
        pagerResult.putDictionary("status", coderEnumsContainer.getEnums("status"));
        return pagerResult;
    }

    @PostMapping("save.json")
    @Operation(method = "保存")

    public Long saveDepartment(@RequestBody DepartmentParam departmentParam) throws BusinessException {
        return this.departmentService.saveDepartment(departmentParam);
    }

    @GetMapping("detail.json")
    @Operation(method = "详情页")
    public DepartmentDTO getDepartment(Long departmentId) throws BusinessException {
        DepartmentBO departmentBo = departmentService.getDepartment(departmentId);
        return this.departmentAssemble.boAssembleDTO(departmentBo);
    }

    @PostMapping("delete.json")
    @Operation(method = "删除")

    public Integer deleteDepartment(@RequestBody Set<Long> ids) throws BusinessException {
        return this.departmentService.deleteDepartment(ids);
    }

    @PostMapping("enable.json")
    @Operation(method = "启用")

    public Integer enableDepartment(@RequestBody Set<Long> ids) throws BusinessException {
        return this.departmentService.enableDepartment(ids);
    }

    @PostMapping("disable.json")
    @Operation(method = "禁用")
    public Integer disableDepartment(@RequestBody Set<Long> ids) throws BusinessException {
        return this.departmentService.disableDepartment(ids);
    }
}
