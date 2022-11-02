package com.sparrow.security.service;

import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.param.GroupStrategyParam;
import com.sparrow.security.repository.GroupStrategyRepository;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Description:
 * @CreateTime: 2022/11/2 0:19
 * @Version:
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com
 */
@Named
public class GroupStrategyService {

    @Inject
    private GroupStrategyRepository groupStrategyRepository;

    public Long saveGroupStrategy(GroupStrategyParam groupStrategyParam){
        return groupStrategyRepository.save(groupStrategyParam);
    }

    public GroupStrategyBO getGroupStrategy(Long id){
        return groupStrategyRepository.getGroupStrategy(id);
    }
}