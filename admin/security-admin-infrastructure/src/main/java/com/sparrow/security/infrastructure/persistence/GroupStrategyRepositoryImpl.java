package com.sparrow.security.infrastructure.persistence;

import com.sparrow.security.dao.GroupStrategyDao;
import com.sparrow.security.infrastructure.persistence.data.mapper.GroupStrategyDataMapper;
import com.sparrow.security.po.GroupStrategy;
import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.param.GroupStrategyParam;
import com.sparrow.security.repository.GroupStrategyRepository;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Description:
 * @CreateTime: 2022/11/2 0:13
 * @Version:
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com
 */
@Named
public class GroupStrategyRepositoryImpl implements GroupStrategyRepository {
    @Inject
    private GroupStrategyDataMapper groupStrategyDataMapper;

    @Inject
    private GroupStrategyDao groupStrategyDao;

    @Override public Long save(GroupStrategyParam groupStrategyParam) {
        GroupStrategy groupStrategy = groupStrategyDataMapper.toPo(groupStrategyParam);
        return groupStrategyDao.insert(groupStrategy);
    }

    @Override public GroupStrategyBO getGroupStrategy(Long id) {
        GroupStrategy groupStrategy = groupStrategyDao.getEntity(id);
        return groupStrategyDataMapper.toBo(groupStrategy);
    }
}