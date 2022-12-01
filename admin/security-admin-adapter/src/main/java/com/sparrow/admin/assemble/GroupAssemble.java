package com.sparrow.admin.assemble;

import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.constant.Config;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.bo.GroupListTotalRecordBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.support.assemble.Param2VOAssemble;
import com.sparrow.support.pager.HtmlPagerResult;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.EnumUtility;
import com.sparrow.utility.StringUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named("groupControllerAssemble")
public class GroupAssemble implements BO2VOAssemble<GroupVO, GroupBO>,
    Param2VOAssemble<GroupVO,GroupParam> {

    private static final int REMARK_MAX_ALLOW_LENGTH=500;

    public GroupVO paramAssembleVO(GroupParam param){
        GroupVO group = new GroupVO();
        BeanUtility.copyProperties(param, group);
        group.setMaxRemarkLength(StringUtility.getMaxAllowLength(REMARK_MAX_ALLOW_LENGTH,param.getRemark()));
        return group;
    }

    @Override public GroupVO boAssembleVO(GroupBO bo) {
        GroupVO group = new GroupVO();
        BeanUtility.copyProperties(bo, group);
        group.setStatus(bo.getStatus().name());

        group.setMaxRemarkLength(StringUtility.getMaxAllowLength(REMARK_MAX_ALLOW_LENGTH,group.getRemark()));
        return group;
    }

    @Override public List<GroupVO> boListAssembleVOList(List<GroupBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<GroupVO> groupVOList = new ArrayList<>(list.size());
        for (GroupBO groupBo : list) {
            GroupVO groupVo = new GroupVO();
            BeanUtility.copyProperties(groupBo, groupVo);
            String statusName = EnumUtility.getValue(groupBo.getStatus());
            groupVo.setStatus(statusName);
            groupVOList.add(groupVo);
        }
        return groupVOList;
    }

    public HtmlPagerResult<GroupVO> assembleHtmlPager(GroupListTotalRecordBO groupListTotalRecord,
        SimplePager groupQuery) {
        List<GroupVO> groupVOList = this.boListAssembleVOList(groupListTotalRecord.getGroups());
        PagerResult<GroupVO> pagerResult = new PagerResult<>(groupQuery);
        pagerResult.setList(groupVOList);
        pagerResult.setRecordCount(groupListTotalRecord.getTotalRecord());
        return new HtmlPagerResult<>(pagerResult);
    }
}
