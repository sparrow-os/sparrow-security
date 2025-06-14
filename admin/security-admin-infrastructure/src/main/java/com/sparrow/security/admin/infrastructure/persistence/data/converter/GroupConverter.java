package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.dao.DatabasePagerQuery;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.dao.query.group.CountGroupQuery;
import com.sparrow.security.admin.dao.query.group.PagerGroupQuery;
import com.sparrow.security.po.Group;
import com.sparrow.security.admin.protocol.param.GroupParam;
import com.sparrow.security.admin.protocol.query.GroupQuery;
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
            return new PagerGroupQuery();
        }
        DatabasePagerQuery pagerQuery = new DatabasePagerQuery(groupQuery.getPageSize(), groupQuery.getPageNo());
        PagerGroupQuery pagerGroupQuery = new PagerGroupQuery();
        this.fullProperties(groupQuery, pagerGroupQuery);
        pagerGroupQuery.setPager(pagerQuery);
        return pagerGroupQuery;
    }

    private void fullProperties(GroupQuery groupQuery, CountGroupQuery dbQuery) {
        if (groupQuery == null) {
            return;
        }
        dbQuery.setGroupName(groupQuery.getGroupName());
        dbQuery.setBeginDate(groupQuery.getBeginDate());
        dbQuery.setEndDate(groupQuery.getEndDate());
    }

    public CountGroupQuery toDbCountQuery(GroupQuery groupQuery) {
        CountGroupQuery countGroupQuery = new CountGroupQuery();
        if (groupQuery == null) {
            return countGroupQuery;
        }
        this.fullProperties(groupQuery, countGroupQuery);
        return countGroupQuery;
    }

    @Override public Group param2po(GroupParam param) {
        Group group = new Group();
        BeanUtility.copyProperties(param, group);
        LoginUser loginToken = ThreadContext.getLoginToken();
        group.setCreateUserId(loginToken.getUserId());
        group.setModifiedUserId(loginToken.getUserId());
        group.setGmtCreate(System.currentTimeMillis());
        group.setGmtModified(group.getGmtCreate());
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
