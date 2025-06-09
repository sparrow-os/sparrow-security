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
package com.sparrow.security.admin.adapter.assemble;

import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.adapter.protocol.vo.SparrowExampleVO;
import com.sparrow.security.admin.domain.bo.SparrowExampleBO;
import com.sparrow.security.admin.protocol.param.SparrowExampleParam;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.support.assemble.Param2VOAssemble;
import com.sparrow.support.pager.HtmlPagerResult;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import com.sparrow.utility.EnumUtility;
import com.sparrow.utility.StringUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named
public class SparrowExampleAssemble implements BO2VOAssemble<SparrowExampleVO, SparrowExampleBO>,
    Param2VOAssemble<SparrowExampleVO,SparrowExampleParam> {

    public SparrowExampleVO paramAssembleVO(SparrowExampleParam param){
        SparrowExampleVO sparrowExample = new SparrowExampleVO();
        BeanUtility.copyProperties(param, sparrowExample);
        return sparrowExample;
    }

    @Override public SparrowExampleVO boAssembleVO(SparrowExampleBO bo) {
        SparrowExampleVO sparrowExample = new SparrowExampleVO();
        BeanUtility.copyProperties(bo, sparrowExample);
        sparrowExample.setStatus(bo.getStatus().name());
        return sparrowExample;
    }

    @Override public List<SparrowExampleVO> boListAssembleVOList(List<SparrowExampleBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<SparrowExampleVO> sparrowExampleVOList = new ArrayList<>(list.size());
        for (SparrowExampleBO sparrowExampleBo : list) {
            SparrowExampleVO sparrowExampleVo = new SparrowExampleVO();
            BeanUtility.copyProperties(sparrowExampleBo, sparrowExampleVo);
            String statusName = EnumUtility.getValue(sparrowExampleBo.getStatus());
            sparrowExampleVo.setStatus(statusName);
            sparrowExampleVOList.add(sparrowExampleVo);
        }
        return sparrowExampleVOList;
    }

    public HtmlPagerResult<SparrowExampleVO> assembleHtmlPager(ListRecordTotalBO<SparrowExampleBO> sparrowExampleListTotalRecord,
        SimplePager sparrowExampleQuery) {
        List<SparrowExampleVO> sparrowExampleVOList = this.boListAssembleVOList(sparrowExampleListTotalRecord.getList());
        PagerResult<SparrowExampleVO> pagerResult = new PagerResult<>(sparrowExampleQuery);
        pagerResult.setList(sparrowExampleVOList);
        pagerResult.setRecordTotal(sparrowExampleListTotalRecord.getTotal());
        return new HtmlPagerResult<>(pagerResult);
    }
}