package com.sparrow.security.assemble;

import com.sparrow.security.protocol.bo.GroupStrategyBO;
import com.sparrow.security.protocol.vo.GroupStrategyVO;
import javax.inject.Named;

/**
 * @Description:
 * @CreateTime: 2022/11/2 0:28
 * @Version:
 * @Since: 1.8
 * @Author: 辛凤文 forward.seen@foxmail.com
 */
@Named
public class GroupStrategyAssemble {
    public GroupStrategyVO bo2Vo(GroupStrategyBO groupStrategyBO){
        return new GroupStrategyVO();
    }
}