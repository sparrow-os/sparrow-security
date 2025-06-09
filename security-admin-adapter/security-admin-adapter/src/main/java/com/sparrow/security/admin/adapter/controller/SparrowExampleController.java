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
import com.sparrow.protocol.TreeItem;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.adapter.assemble.SparrowExampleAssemble;
import com.sparrow.security.admin.domain.bo.SparrowExampleBO;
import com.sparrow.security.admin.protocol.param.SparrowExampleParam;
import com.sparrow.security.admin.protocol.param.batch.SparrowExampleBatchOperateParam;
import com.sparrow.security.admin.protocol.query.SparrowExampleQuery;
import com.sparrow.security.admin.adapter.protocol.vo.SparrowExampleVO;
import com.sparrow.security.admin.domain.service.SparrowExampleService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("sparrow/security")
public class SparrowExampleController {

    @Inject
    private SparrowExampleService sparrowExampleService;

    @Inject
    private SparrowExampleAssemble sparrowExampleAssemble;

    @GetMapping("manage")
    public ModelAndView loadAllSparrowExamples() {
        SparrowExampleBatchOperateParam batchOperationQuery = ModelAndViewUtils.query();
        if (batchOperationQuery != null) {
            return this.querySparrowExamples(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<SparrowExampleBO> sparrowExampleListTotalRecord = this.sparrowExampleService.queryAllSparrowExample();
        HtmlPagerResult<SparrowExampleVO> pager = this.sparrowExampleAssemble.assembleHtmlPager(sparrowExampleListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/sparrow/security/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView querySparrowExamples(SparrowExampleQuery sparrowExampleQuery) {
        ListRecordTotalBO<SparrowExampleBO> sparrowExampleListTotalRecord = this.sparrowExampleService.querySparrowExample(sparrowExampleQuery);
        HtmlPagerResult<SparrowExampleVO> pager = this.sparrowExampleAssemble.assembleHtmlPager(sparrowExampleListTotalRecord, sparrowExampleQuery);
        ModelAndView mv = new ModelAndView("/sparrow/security/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(SparrowExampleQuery sparrowExampleQuery) {
        return this.querySparrowExamples(sparrowExampleQuery);
    }

    @PostMapping("save")
    public ModelAndView saveSparrowExample(SparrowExampleParam sparrowExampleParam) throws BusinessException {
       this.sparrowExampleService.saveSparrowExample(sparrowExampleParam);
       return ModelAndViewUtils.redirect("/sparrow/security/manage");
    }

    @GetMapping("edit")
    public ModelAndView getSparrowExample(Long sparrowExampleId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/sparrow/security/new");
        if (sparrowExampleId == null) {
            return mv;
        }

        SparrowExampleBO sparrowExampleBo = sparrowExampleService.getSparrowExample(sparrowExampleId);
        SparrowExampleVO sparrowExampleVo = this.sparrowExampleAssemble.boAssembleVO(sparrowExampleBo);
        mv.addObject("sparrowExample", sparrowExampleVo);
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView deleteSparrowExample(SparrowExampleBatchOperateParam batchOperationQuery) throws BusinessException {
        this.sparrowExampleService.deleteSparrowExample(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/sparrow/security/manage");
    }

    @PostMapping("enable")
    public ModelAndView enableSparrowExample(SparrowExampleBatchOperateParam batchOperationQuery) throws BusinessException {
        this.sparrowExampleService.enableSparrowExample(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/sparrow/security/manage");
    }

    @PostMapping("disable")
    public ModelAndView disableSparrowExample(SparrowExampleBatchOperateParam batchOperationQuery) throws BusinessException {
        this.sparrowExampleService.disableSparrowExample(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/sparrow/security/manage");
    }
}