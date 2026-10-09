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
import com.sparrow.security.admin.adapter.assemble.DictItemI18nAssemble;
import com.sparrow.security.admin.domain.bo.DictItemI18nBO;
import com.sparrow.security.admin.protocol.param.DictItemI18nParam;
import com.sparrow.security.admin.protocol.query.DictItemI18nQuery;
import com.sparrow.security.admin.protocol.dto.DictItemI18nDTO;
import com.sparrow.security.admin.domain.service.DictItemI18nService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;

import com.sparrow.security.admin.domain.service.DictItemService;




@RestController
@RequestMapping("dict/item/i18n")
@Tag(name = "DictItemI18n")
public class DictItemI18nController {

    @Inject
    private DictItemI18nService dictItemI18nService;

    @Inject
    private DictItemI18nAssemble dictItemI18nAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
 @Inject
 private DictItemService dictItemService;
@Inject
private EnumsContainer businessEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<DictItemI18nDTO> search(@RequestBody DictItemI18nQuery dictItemI18nQuery) {
        
        ListRecordTotalBO<DictItemI18nBO> dictItemI18nListTotalRecord = this.dictItemI18nService.queryDictItemI18n(dictItemI18nQuery);
        PagerResult<DictItemI18nDTO> pagerResult =this.dictItemI18nAssemble.assemblePager(dictItemI18nListTotalRecord, dictItemI18nQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("dictItemId",this.dictItemService.getDictItemKvs());

pagerResult.putDictionary("locale",businessEnumsContainer.getEnums("I18nLocale"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveDictItemI18n(@RequestBody DictItemI18nParam dictItemI18nParam) throws BusinessException {
       return  this.dictItemI18nService.saveDictItemI18n(dictItemI18nParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public DictItemI18nDTO getDictItemI18n(Long dictItemI18nId) throws BusinessException {
        DictItemI18nBO dictItemI18nBo = dictItemI18nService.getDictItemI18n(dictItemI18nId);
        return this.dictItemI18nAssemble.boAssembleDTO(dictItemI18nBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteDictItemI18n(@RequestBody Set<Long> ids) throws BusinessException {
       return this.dictItemI18nService.deleteDictItemI18n(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableDictItemI18n(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.dictItemI18nService.enableDictItemI18n(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableDictItemI18n(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.dictItemI18nService.disableDictItemI18n(ids);
    }
}