package com.sparrow.security.service;

import com.sparrow.security.protocol.vo.GroupVO;
import com.sparrow.security.protocol.param.GroupParam;
import com.sparrow.security.protocol.query.GroupQuery;
import com.sparrow.security.repository.GroupRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupService {
    @Inject
    private GroupRepository groupRepository;
    public Long saveGroup(GroupParam groupParam) {
        return this.groupRepository.save(groupParam);
    }

    public void deleteGroup(Long groupId) {

    }

    public List<GroupVO> queryGroup(GroupQuery groupQuery) {
        return null;
    }

    public GroupVO getGroup(Long groupId) {
        return this.groupRepository.getGroup(groupId);
    }
}
