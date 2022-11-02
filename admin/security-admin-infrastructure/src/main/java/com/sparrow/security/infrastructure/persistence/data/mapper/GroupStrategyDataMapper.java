package com.sparrow.security.infrastructure.persistence.data.mapper;

import com.sparrow.security.po.GroupStrategy;
import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.param.GroupStrategyParam;

/**
 * @Description:
 * @CreateTime: 2022/11/2 0:04
 * @Version:
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com
 */
public class GroupStrategyDataMapper {

    public GroupStrategy toPo(GroupStrategyParam groupStrategyParam){
        //TODO A Object GroupStrategyParam to GroupStrategy Object
        return new GroupStrategy();
    }

    public GroupStrategyBO toBo(GroupStrategy groupStrategy){
        //TODO A Object GroupStrategy to GroupStrategyBO Object
        return new GroupStrategyBO();
    }
}