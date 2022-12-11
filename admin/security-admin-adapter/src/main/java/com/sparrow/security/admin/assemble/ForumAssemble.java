package com.sparrow.security.admin.assemble;

import com.sparrow.protocol.constant.Constant;
import com.sparrow.security.admin.protocol.vo.ForumVO;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.protocol.param.ForumParam;
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

@Named("forumControllerAssemble")
public class ForumAssemble implements BO2VOAssemble<ForumVO, ForumBO>,
    Param2VOAssemble<ForumVO,ForumParam> {

    public ForumVO paramAssembleVO(ForumParam param){
        ForumVO forum = new ForumVO();
        BeanUtility.copyProperties(param, forum);
        forum.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH,param.getRemark()));
        return forum;
    }

    @Override public ForumVO boAssembleVO(ForumBO bo) {
        ForumVO forum = new ForumVO();
        BeanUtility.copyProperties(bo, forum);
        forum.setStatus(bo.getStatus().name());

        forum.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH,forum.getRemark()));
        return forum;
    }

    @Override public List<ForumVO> boListAssembleVOList(List<ForumBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<ForumVO> forumVOList = new ArrayList<>(list.size());
        for (ForumBO forumBo : list) {
            ForumVO forumVo = new ForumVO();
            BeanUtility.copyProperties(forumBo, forumVo);
            String statusName = EnumUtility.getValue(forumBo.getStatus());
            forumVo.setStatus(statusName);
            forumVOList.add(forumVo);
        }
        return forumVOList;
    }

    public HtmlPagerResult<ForumVO> assembleHtmlPager(ListRecordTotalBO<ForumBO> forumListTotalRecord,
        SimplePager forumQuery) {
        List<ForumVO> forumVOList = this.boListAssembleVOList(forumListTotalRecord.getList());
        PagerResult<ForumVO> pagerResult = new PagerResult<>(forumQuery);
        pagerResult.setList(forumVOList);
        pagerResult.setRecordCount(forumListTotalRecord.getTotal());
        return new HtmlPagerResult<>(pagerResult);
    }
}