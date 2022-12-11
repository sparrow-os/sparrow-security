package com.sparrow.security.admin.assemble;

import com.sparrow.security.admin.protocol.vo.RoleVO;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.RoleParam;
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

@Named("roleControllerAssemble")
public class RoleAssemble implements BO2VOAssemble<RoleVO, RoleBO>,
    Param2VOAssemble<RoleVO, RoleParam> {
    public RoleVO paramAssembleVO(RoleParam param) {
        RoleVO role = new RoleVO();
        BeanUtility.copyProperties(param, role);
        role.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH, param.getRemark()));
        return role;
    }

    @Override public RoleVO boAssembleVO(RoleBO bo) {
        RoleVO role = new RoleVO();
        BeanUtility.copyProperties(bo, role);
        role.setStatus(bo.getStatus().name());

        role.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH, bo.getRemark()));
        return role;
    }

    @Override public List<RoleVO> boListAssembleVOList(List<RoleBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<RoleVO> roleVOList = new ArrayList<>(list.size());
        for (RoleBO roleBo : list) {
            RoleVO roleVo = new RoleVO();
            BeanUtility.copyProperties(roleBo, roleVo);
            String statusName = EnumUtility.getValue(roleBo.getStatus());
            roleVo.setStatus(statusName);
            roleVOList.add(roleVo);
        }
        return roleVOList;
    }

    public HtmlPagerResult<RoleVO> assembleHtmlPager(ListRecordTotalBO<RoleBO> roleListTotalRecord,
        SimplePager roleQuery) {
        List<RoleVO> roleVOList = this.boListAssembleVOList(roleListTotalRecord.getList());
        PagerResult<RoleVO> pagerResult = new PagerResult<>(roleQuery);
        pagerResult.setList(roleVOList);
        pagerResult.setRecordCount(roleListTotalRecord.getTotal());
        return new HtmlPagerResult<>(pagerResult);
    }
}
