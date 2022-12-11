package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.protocol.enums.SecurityAdminError;
import com.sparrow.security.admin.protocol.param.ForumParam;
import com.sparrow.security.admin.protocol.query.ForumQuery;
import com.sparrow.security.admin.repository.ForumRepository;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ForumService {
    @Inject
    private ForumRepository forumRepository;

    private void validateSaveForum(ForumParam forumParam) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(forumParam.getForumName()), SecurityAdminError.FORUM_NAME_IS_EMPTY);
    }

    public Long saveForum(ForumParam forumParam) throws BusinessException {
        this.validateSaveForum(forumParam);
        return this.forumRepository.save(forumParam);
    }

    public Integer deleteForum(String forumIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(forumIds), SecurityAdminError.FORUM_ID_IS_EMPTY);
        return this.forumRepository.delete(forumIds);
    }

    public Integer enableForum(String forumIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(forumIds), SecurityAdminError.FORUM_ID_IS_EMPTY);
        return this.forumRepository.enable(forumIds);
    }

    public Integer disableForum(String forumIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(forumIds), SecurityAdminError.FORUM_ID_IS_EMPTY);
        return this.forumRepository.disable(forumIds);
    }

    public ListRecordTotalBO<ForumBO> queryAllForum() {
        return queryForum(null);
    }

    public ListRecordTotalBO<ForumBO> queryForum(ForumQuery forumQuery) {
        Long totalRecord = this.forumRepository.getForumCount(forumQuery);
        List<ForumBO> forumBoList = null;
        if (totalRecord > 0) {
            forumBoList = this.forumRepository.queryForums(forumQuery);
        }
        return new ListRecordTotalBO<>(forumBoList, totalRecord);
    }

    public ForumBO getForum(Long forumId) throws BusinessException {
        Asserts.isTrue(forumId == null, SecurityAdminError.FORUM_ID_IS_EMPTY);
        return this.forumRepository.getForum(forumId);
    }
}