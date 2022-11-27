package com.sparrow.security.infrastructure.persistence.admin.data.converter;

import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.dao.PagerQuery;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.dao.admin.query.CountGroupQuery;
import com.sparrow.security.dao.admin.query.PagerGroupQuery;
import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class GroupConverter implements Param2POConverter<GroupParam, Group>, PO2BOConverter<GroupBO, Group> {
    public PagerGroupQuery toDbPagerQuery(GroupQuery groupQuery) {
        if (groupQuery == null) {
            PagerGroupQuery pagerGroupQuery = new PagerGroupQuery();
            pagerGroupQuery.setPager(new PagerQuery());
            return pagerGroupQuery;
        }
        PagerQuery pagerQuery = new PagerQuery(groupQuery.getPageSize(), groupQuery.getCurrentPageIndex());
        PagerGroupQuery pagerGroupQuery = new PagerGroupQuery(this.toDbCountQuery(groupQuery));
        pagerGroupQuery.setPager(pagerQuery);
        return pagerGroupQuery;
    }

    public CountGroupQuery toDbCountQuery(GroupQuery groupQuery) {
        CountGroupQuery countGroupQuery = new CountGroupQuery();
        if (groupQuery == null) {
            return countGroupQuery;
        }
        countGroupQuery.setGroupName(groupQuery.getGroupName());
        countGroupQuery.setBeginDate(groupQuery.getBeginDate());
        countGroupQuery.setEndDate(groupQuery.getEndDate());
        return countGroupQuery;
    }

    @Override public Group param2po(GroupParam param) {
        Group group = new Group();
        BeanUtility.copyProperties(param, group);
        LoginToken loginToken = new LoginToken();
        loginToken.setUserId(1L);
        // ThreadContext.getLoginToken();
        group.setCreateUserId(loginToken.getUserId());
        group.setUpdateUserId(loginToken.getUserId());
        group.setCreateTime(System.currentTimeMillis());
        group.setUpdateTime(group.getCreateTime());
        group.setStatus(StatusRecord.ENABLE);
        return group;
    }

    @Override public GroupBO po2bo(Group group) {
        GroupBO groupBo = new GroupBO();
        BeanUtility.copyProperties(group, groupBo);
        return groupBo;
    }

    @Override public List<GroupBO> poList2BoList(List<Group> list) {
        List<GroupBO> groupBos = new ArrayList<>(list.size());
        for (Group group : list) {
            groupBos.add(this.po2bo(group));
        }
        return groupBos;
    }
}
