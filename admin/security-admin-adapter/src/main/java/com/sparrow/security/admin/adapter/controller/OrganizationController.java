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
import com.sparrow.security.admin.adapter.assemble.OrganizationAssemble;
import com.sparrow.security.admin.domain.bo.OrganizationBO;
import com.sparrow.security.admin.domain.service.OrganizationService;
import com.sparrow.security.admin.protocol.dto.OrganizationDTO;
import com.sparrow.security.admin.protocol.param.OrganizationParam;
import com.sparrow.security.admin.protocol.query.OrganizationQuery;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("organization")
@Tag(name = "Organization")
public class OrganizationController {

    @Inject
    private OrganizationService organizationService;

    @Inject
    private OrganizationAssemble organizationAssemble;

    @Inject
    private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method = "搜索")
    public PagerResult<OrganizationDTO> search(@RequestBody OrganizationQuery organizationQuery) {
        ListRecordTotalBO<OrganizationBO> organizationListTotalRecord = this.organizationService.queryOrganization(organizationQuery);
        PagerResult<OrganizationDTO> pagerResult = this.organizationAssemble.assemblePager(organizationListTotalRecord, organizationQuery);
        pagerResult.putDictionary("status", coderEnumsContainer.getEnums("status"));
        pagerResult.putDictionary("parentId", this.organizationService.getOrganizationKvs());

        return pagerResult;
    }

    @PostMapping("save.json")
    @Operation(method = "保存")

    public Long saveOrganization(@RequestBody OrganizationParam organizationParam) throws BusinessException {
        return this.organizationService.saveOrganization(organizationParam);
    }

    @GetMapping("detail.json")
    @Operation(method = "详情页")
    public OrganizationDTO getOrganization(Long organizationId) throws BusinessException {
        OrganizationBO organizationBo = organizationService.getOrganization(organizationId);
        return this.organizationAssemble.boAssembleDTO(organizationBo);
    }

    @PostMapping("delete.json")
    @Operation(method = "删除")

    public Integer deleteOrganization(@RequestBody Set<Long> ids) throws BusinessException {
        return this.organizationService.deleteOrganization(ids);
    }

    @PostMapping("enable.json")
    @Operation(method = "启用")

    public Integer enableOrganization(@RequestBody Set<Long> ids) throws BusinessException {
        return this.organizationService.enableOrganization(ids);
    }

    @PostMapping("disable.json")
    @Operation(method = "禁用")
    public Integer disableOrganization(@RequestBody Set<Long> ids) throws BusinessException {
        return this.organizationService.disableOrganization(ids);
    }
}
