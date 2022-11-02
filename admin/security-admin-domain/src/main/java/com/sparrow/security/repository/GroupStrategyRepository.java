package com.sparrow.security.repository;

import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.param.GroupStrategyParam;

/**
 * @Description: 
 * @CreateTime: 2022/11/1 23:54
 * @Version: 
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com 
 */
public interface GroupStrategyRepository {

    Long save(GroupStrategyParam groupStrategyParam);

    GroupStrategyBO getGroupStrategy(Long id);

}