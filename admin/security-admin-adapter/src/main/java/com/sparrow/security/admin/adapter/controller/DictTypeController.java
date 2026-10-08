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
import com.sparrow.security.admin.adapter.assemble.DictTypeAssemble;
import com.sparrow.security.admin.domain.bo.DictTypeBO;
import com.sparrow.security.admin.protocol.param.DictTypeParam;
import com.sparrow.security.admin.protocol.query.DictTypeQuery;
import com.sparrow.security.admin.protocol.dto.DictTypeDTO;
import com.sparrow.security.admin.domain.service.DictTypeService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("dict/type")
@Tag(name = "DictType")
public class DictTypeController {

    @Inject
    private DictTypeService dictTypeService;

    @Inject
    private DictTypeAssemble dictTypeAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<DictTypeDTO> search(@RequestBody DictTypeQuery dictTypeQuery) {
        ListRecordTotalBO<DictTypeBO> dictTypeListTotalRecord = this.dictTypeService.queryDictType(dictTypeQuery);
        PagerResult<DictTypeDTO> pagerResult =this.dictTypeAssemble.assemblePager(dictTypeListTotalRecord, dictTypeQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveDictType(@RequestBody DictTypeParam dictTypeParam) throws BusinessException {
       return  this.dictTypeService.saveDictType(dictTypeParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public DictTypeDTO getDictType(Long dictTypeId) throws BusinessException {
        DictTypeBO dictTypeBo = dictTypeService.getDictType(dictTypeId);
        return this.dictTypeAssemble.boAssembleDTO(dictTypeBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteDictType(@RequestBody Set<Long> ids) throws BusinessException {
       return this.dictTypeService.deleteDictType(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableDictType(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.dictTypeService.enableDictType(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableDictType(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.dictTypeService.disableDictType(ids);
    }
}