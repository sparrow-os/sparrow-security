package com.sparrow.security.admin.assemble;

import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.TreeItem;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.param.GroupParam;
import com.sparrow.security.admin.protocol.vo.AppVO;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.protocol.vo.GroupVO;
import com.sparrow.support.assemble.BO2VOAssemble;
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
public class AppAssemble implements BO2VOAssemble<AppVO, AppBO> {

    public List<TreeItem> toTreeItemList(List<AppBO> appBos) {
        if (CollectionsUtility.isNullOrEmpty(appBos)) {
            return Collections.emptyList();
        }
        List<TreeItem> treeItems = new ArrayList<>(appBos.size());
        for (AppBO app : appBos) {
            TreeItem treeItem = new TreeItem();
            treeItem.setCode(app.getCode());
            treeItem.setName(app.getName());
            treeItem.setId(app.getId().intValue());
            treeItem.setParentId(0);
            treeItems.add(treeItem);
        }
        return treeItems;
    }

    @Override public AppVO boAssembleVO(AppBO bo) {
        AppVO appVo = new AppVO();
        BeanUtility.copyProperties(bo, appVo);
        appVo.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH, bo.getRemark()));
        appVo.setStatus(bo.getStatus().name());
        return appVo;
    }

    public AppVO paramAssembleVO(AppParam param) {
        AppVO app = new AppVO();
        BeanUtility.copyProperties(param, app);
        app.setMaxRemarkLength(StringUtility.getMaxAllowLength(Constant.MAX_REMARK_LENGTH, param.getRemark()));
        return app;
    }

    @Override public List<AppVO> boListAssembleVOList(List<AppBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<AppVO> appVoList = new ArrayList<>(list.size());
        for (AppBO appBO : list) {
            AppVO appVo = new AppVO();
            BeanUtility.copyProperties(appBO, appVo);
            String statusName = EnumUtility.getValue(appBO.getStatus());
            appVo.setStatus(statusName);
            appVoList.add(appVo);
        }
        return appVoList;
    }

    public HtmlPagerResult<AppVO> assembleHtmlPager(ListRecordTotalBO<AppBO> appListTotalRecord,
        SimplePager groupQuery) {
        List<AppVO> appVOList = this.boListAssembleVOList(appListTotalRecord.getList());
        PagerResult<AppVO> pagerResult = new PagerResult<>(groupQuery);
        pagerResult.setList(appVOList);
        pagerResult.setRecordCount(appListTotalRecord.getTotal());
        return new HtmlPagerResult<>(pagerResult);
    }
}
