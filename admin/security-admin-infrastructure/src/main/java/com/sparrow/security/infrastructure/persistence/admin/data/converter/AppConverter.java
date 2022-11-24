package com.sparrow.security.infrastructure.persistence.admin.data.converter;

import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.po.App;
import com.sparrow.security.protocol.admin.param.AppParam;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class AppConverter implements Param2POConverter<AppParam, App>, PO2BOConverter<AppBO, App> {
    public AppBO toBo(App app) {
        AppBO appBo = new AppBO();
        BeanUtility.copyProperties(app, appBo);
        return appBo;
    }

    @Override public App param2po(AppParam param) {
        App app = new App();
        BeanUtility.copyProperties(param, app);
        app.setCreateTime(System.currentTimeMillis());
        app.setUpdateTime(app.getCreateTime());
        app.setCreateUserId(0L);
        app.setUpdateUserId(0L);
        app.setStatus(StatusRecord.ENABLE);
        if (app.getRemark() == null) {
            app.setRemark("");
        }
        return app;
    }

    @Override public AppBO po2bo(App app) {
        AppBO appBO = new AppBO();
        BeanUtility.copyProperties(app, appBO);
        return appBO;
    }

    @Override public List<AppBO> poList2BoList(List<App> list) {
        List<AppBO> appBos = new ArrayList<>(list.size());
        for (App app : list) {
            appBos.add(this.po2bo(app));
        }
        return appBos;
    }
}
