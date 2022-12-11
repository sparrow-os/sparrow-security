package com.sparrow.security.admin.assemble;

import com.sparrow.security.admin.protocol.vo.AppVO;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named("appControllerAssemble")
public class AppAssemble implements BO2VOAssemble<AppVO, AppBO> {
    @Override public AppVO boAssembleVO(AppBO bo) {
        AppVO appVo = new AppVO();
        BeanUtility.copyProperties(bo, appVo);
        return appVo;
    }

    @Override public List<AppVO> boListAssembleVOList(List<AppBO> list) {
        List<AppVO> appVos = new ArrayList<>(list.size());
        for (AppBO appBo : list) {
            appVos.add(this.boAssembleVO(appBo));
        }
        return appVos;
    }
}
