package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.assemble.ForumAssemble;
import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.protocol.param.ForumParam;
import com.sparrow.security.admin.protocol.query.ForumBatchOperationQuery;
import com.sparrow.security.admin.protocol.query.ForumQuery;
import com.sparrow.security.admin.protocol.vo.ForumVO;
import com.sparrow.security.admin.service.ForumService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("forum")
public class ForumController {

    @Inject
    private ForumService forumService;
    @Inject
    private ForumAssemble forumControllerAssemble;
    @Inject
    private ServletContainer servletContainer;

    @GetMapping("manage")
    public ModelAndView loadAllForums() {
        ForumBatchOperationQuery batchOperationQuery = (ForumBatchOperationQuery) ModelAndViewUtils.flash("query");
        if (batchOperationQuery != null) {
            return this.queryForums(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<ForumBO> forumListTotalRecord = this.forumService.queryAllForum();
        HtmlPagerResult<ForumVO> pager = this.forumControllerAssemble.assembleHtmlPager(forumListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/forum/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryForums(ForumQuery forumQuery) {
        ListRecordTotalBO<ForumBO> forumListTotalRecord = this.forumService.queryForum(forumQuery);
        HtmlPagerResult<ForumVO> pager = this.forumControllerAssemble.assembleHtmlPager(forumListTotalRecord, forumQuery);
        ModelAndView mv = new ModelAndView("/forum/manage");
        mv.addObject("pager", pager);
        mv.addObject("query", forumQuery);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(ForumQuery forumQuery) {
        return this.queryForums(forumQuery);
    }

    @PostMapping("save")
    public ModelAndView saveForum(@RequestBody ForumParam forumParam) throws BusinessException {
        try {
            forumService.saveForum(forumParam);
            return ModelAndViewUtils.redirect("/forum/manage");
        } catch (Exception e) {
            //失败回显
            this.servletContainer.getRequest().setAttribute("forum", this.forumControllerAssemble.paramAssembleVO(forumParam));
            throw e;
        }
    }

    @GetMapping("get")
    public ForumVO getForum(Long forumId) throws BusinessException {
        ForumBO forumBo = this.forumService.getForum(forumId);
        return this.forumControllerAssemble.boAssembleVO(forumBo);
    }

    @PostMapping("delete")
    public Integer deleteForum(String forumIds) throws BusinessException {
        return this.forumService.deleteForum(forumIds);
    }

    @PostMapping("enable")
    public Integer enableForum(String forumIds) throws BusinessException {
        return this.forumService.enableForum(forumIds);
    }

    @PostMapping("disable")
    public Integer disableForum(String forumIds) throws BusinessException {
        return this.forumService.disableForum(forumIds);
    }
}