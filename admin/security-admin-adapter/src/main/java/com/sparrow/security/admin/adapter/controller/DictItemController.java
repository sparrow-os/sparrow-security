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
import com.sparrow.security.admin.adapter.assemble.DictItemAssemble;
import com.sparrow.security.admin.domain.bo.DictItemBO;
import com.sparrow.security.admin.protocol.param.DictItemParam;
import com.sparrow.security.admin.protocol.query.DictItemQuery;
import com.sparrow.security.admin.protocol.dto.DictItemDTO;
import com.sparrow.security.admin.domain.service.DictItemService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;
import com.sparrow.security.admin.domain.service.DictTypeService;




@RestController
@RequestMapping("dict/item")
@Tag(name = "DictItem")
public class DictItemController {

    @Inject
    private DictItemService dictItemService;

    @Inject
    private DictItemAssemble dictItemAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
 @Inject
 private DictTypeService dictTypeService;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<DictItemDTO> search(@RequestBody DictItemQuery dictItemQuery) {
        ListRecordTotalBO<DictItemBO> dictItemListTotalRecord = this.dictItemService.queryDictItem(dictItemQuery);
        PagerResult<DictItemDTO> pagerResult =this.dictItemAssemble.assemblePager(dictItemListTotalRecord, dictItemQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("parentId",this.dictItemService.getDictItemKvs());

pagerResult.putDictionary("dictTypeId",this.dictTypeService.getDictTypeKvs());

        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveDictItem(@RequestBody DictItemParam dictItemParam) throws BusinessException {
       return  this.dictItemService.saveDictItem(dictItemParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public DictItemDTO getDictItem(Long dictItemId) throws BusinessException {
        DictItemBO dictItemBo = dictItemService.getDictItem(dictItemId);
        return this.dictItemAssemble.boAssembleDTO(dictItemBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteDictItem(@RequestBody Set<Long> ids) throws BusinessException {
       return this.dictItemService.deleteDictItem(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableDictItem(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.dictItemService.enableDictItem(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableDictItem(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.dictItemService.disableDictItem(ids);
    }
}