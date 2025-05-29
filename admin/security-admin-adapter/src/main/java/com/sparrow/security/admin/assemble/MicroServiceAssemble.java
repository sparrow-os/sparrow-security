package com.sparrow.security.admin.assemble;

import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.vo.MicroServiceVO;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.support.assemble.Param2VOAssemble;
import com.sparrow.support.pager.HtmlPagerResult;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import com.sparrow.utility.StringUtility;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named("microServiceControllerAssemble")
public class MicroServiceAssemble implements BO2VOAssemble<MicroServiceVO, MicroServiceBO>,
    Param2VOAssemble<MicroServiceVO,MicroServiceParam> {

    public MicroServiceVO paramAssembleVO(MicroServiceParam param){
        MicroServiceVO microService = new MicroServiceVO();
        BeanUtility.copyProperties(param, microService);
        microService.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH,param.getRemark()));
        return microService;
    }

    @Override public MicroServiceVO boAssembleVO(MicroServiceBO bo) {
        MicroServiceVO microService = new MicroServiceVO();
        BeanUtility.copyProperties(bo, microService);
        microService.setStatus(bo.getStatus().name());

        microService.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH,microService.getRemark()));
        return microService;
    }

    @Override public List<MicroServiceVO> boListAssembleVOList(List<MicroServiceBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<MicroServiceVO> microServiceVOList = new ArrayList<>(list.size());
        for (MicroServiceBO microServiceBo : list) {
            MicroServiceVO microServiceVo = new MicroServiceVO();
            BeanUtility.copyProperties(microServiceBo, microServiceVo);
            microServiceVo.setStatus(microServiceBo.getStatus().name());
            microServiceVOList.add(microServiceVo);
        }
        return microServiceVOList;
    }

    public HtmlPagerResult<MicroServiceVO> assembleHtmlPager(ListRecordTotalBO<MicroServiceBO> microServiceListTotalRecord,
        SimplePager microServiceQuery) {
        List<MicroServiceVO> microServiceVOList = this.boListAssembleVOList(microServiceListTotalRecord.getList());
        PagerResult<MicroServiceVO> pagerResult = new PagerResult<>(microServiceQuery);
        pagerResult.setList(microServiceVOList);
        pagerResult.setRecordTotal(microServiceListTotalRecord.getTotal());
        return new HtmlPagerResult<>(pagerResult);
    }
}
