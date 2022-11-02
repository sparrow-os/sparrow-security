package com.sparrow.security.controller;

import com.sparrow.protocol.Result;
import com.sparrow.security.assemble.GroupStrategyAssemble;
import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.param.GroupStrategyParam;
import com.sparrow.security.protocol.vo.GroupStrategyVO;
import com.sparrow.security.service.GroupStrategyService;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Description:
 * @CreateTime: 2022/11/2 0:26
 * @Version:
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com
 */
@Named
public class GroupStrategyController {

    @Inject
    private GroupStrategyAssemble groupStrategyAssemble;

    @Inject
    private GroupStrategyService groupStrategyService;

    public Result<Long> saveGroupStrategy(GroupStrategyParam groupStrategyParam){
        Long i = groupStrategyService.saveGroupStrategy(groupStrategyParam);
        return new Result<>(i);
    }

    public GroupStrategyVO getGroupStrategy(Long id){
        GroupStrategyBO groupStrategyBO = groupStrategyService.getGroupStrategy(id);
        return groupStrategyAssemble.bo2Vo(groupStrategyBO);
    }

}