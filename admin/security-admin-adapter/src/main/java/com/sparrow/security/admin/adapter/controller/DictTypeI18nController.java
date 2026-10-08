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
import com.sparrow.security.admin.adapter.assemble.DictTypeI18nAssemble;
import com.sparrow.security.admin.domain.bo.DictTypeI18nBO;
import com.sparrow.security.admin.protocol.param.DictTypeI18nParam;
import com.sparrow.security.admin.protocol.query.DictTypeI18nQuery;
import com.sparrow.security.admin.protocol.dto.DictTypeI18nDTO;
import com.sparrow.security.admin.domain.service.DictTypeI18nService;
import com.sparrow.spring.container.EnumsContainer;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;
import com.sparrow.security.admin.domain.service.DictTypeService;




@RestController
@RequestMapping("dict/type/i18n")
@Tag(name = "DictTypeI18n")
public class DictTypeI18nController {

    @Inject
    private DictTypeI18nService dictTypeI18nService;

    @Inject
    private DictTypeI18nAssemble dictTypeI18nAssemble;

    @Inject
private EnumsContainer coderEnumsContainer;
 @Inject
 private DictTypeService dictTypeService;
@Inject
private EnumsContainer businessEnumsContainer;

    @PostMapping("search.json")
    @Operation(method="搜索")
    public PagerResult<DictTypeI18nDTO> search(@RequestBody DictTypeI18nQuery dictTypeI18nQuery) {
        ListRecordTotalBO<DictTypeI18nBO> dictTypeI18nListTotalRecord = this.dictTypeI18nService.queryDictTypeI18n(dictTypeI18nQuery);
        PagerResult<DictTypeI18nDTO> pagerResult =this.dictTypeI18nAssemble.assemblePager(dictTypeI18nListTotalRecord, dictTypeI18nQuery);
        pagerResult.putDictionary("status",coderEnumsContainer.getEnums("status"));
pagerResult.putDictionary("dictTypeId",this.dictTypeService.getDictTypeKvs());

pagerResult.putDictionary("locale",businessEnumsContainer.getEnums("I18nLocale"));
        return pagerResult;
    }

    @PostMapping("save.json")
            @Operation(method="保存")

    public Long saveDictTypeI18n(@RequestBody DictTypeI18nParam dictTypeI18nParam) throws BusinessException {
       return  this.dictTypeI18nService.saveDictTypeI18n(dictTypeI18nParam);
    }

    @GetMapping("detail.json")
            @Operation(method="详情页")
    public DictTypeI18nDTO getDictTypeI18n(Long dictTypeI18nId) throws BusinessException {
        DictTypeI18nBO dictTypeI18nBo = dictTypeI18nService.getDictTypeI18n(dictTypeI18nId);
        return this.dictTypeI18nAssemble.boAssembleDTO(dictTypeI18nBo);
    }

    @PostMapping("delete.json")
            @Operation(method="删除")

    public Integer deleteDictTypeI18n(@RequestBody Set<Long> ids) throws BusinessException {
       return this.dictTypeI18nService.deleteDictTypeI18n(ids);
    }

    @PostMapping("enable.json")
            @Operation(method="启用")

    public Integer enableDictTypeI18n(@RequestBody Set<Long> ids) throws BusinessException {
        return  this.dictTypeI18nService.enableDictTypeI18n(ids);
    }

    @PostMapping("disable.json")
    @Operation(method="禁用")
    public Integer disableDictTypeI18n(@RequestBody Set<Long> ids) throws BusinessException {
       return  this.dictTypeI18nService.disableDictTypeI18n(ids);
    }
}