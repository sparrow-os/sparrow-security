/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sparrow.passport.admin.adapter.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.TreeItem;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.passport.admin.adapter.assemble.UserAssemble;
import com.sparrow.passport.admin.domain.bo.UserBO;
import com.sparrow.passport.admin.protocol.param.UserParam;
import com.sparrow.passport.admin.protocol.param.batch.UserBatchOperateParam;
import com.sparrow.passport.admin.protocol.query.UserQuery;
import com.sparrow.passport.admin.adapter.protocol.vo.UserVO;
import com.sparrow.passport.admin.domain.service.UserService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("user")
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private UserAssemble userAssemble;

    @GetMapping("manage")
    public ModelAndView loadAllUsers() {
        UserBatchOperateParam batchOperationQuery = ModelAndViewUtils.query();
        if (batchOperationQuery != null) {
            return this.queryUsers(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<UserBO> userListTotalRecord = this.userService.queryAllUser();
        HtmlPagerResult<UserVO> pager = this.userAssemble.assembleHtmlPager(userListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/user/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryUsers(UserQuery userQuery) {
        ListRecordTotalBO<UserBO> userListTotalRecord = this.userService.queryUser(userQuery);
        HtmlPagerResult<UserVO> pager = this.userAssemble.assembleHtmlPager(userListTotalRecord, userQuery);
        ModelAndView mv = new ModelAndView("/user/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(UserQuery userQuery) {
        return this.queryUsers(userQuery);
    }

    @PostMapping("save")
    public ModelAndView saveUser(UserParam userParam) throws BusinessException {
       this.userService.saveUser(userParam);
       return ModelAndViewUtils.redirect("/user/manage");
    }

    @GetMapping("edit")
    public ModelAndView getUser(Long userId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/user/new");
        if (userId == null) {
            return mv;
        }

        UserBO userBo = userService.getUser(userId);
        UserVO userVo = this.userAssemble.boAssembleVO(userBo);
        mv.addObject("user", userVo);
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView deleteUser(UserBatchOperateParam batchOperationQuery) throws BusinessException {
        this.userService.deleteUser(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/user/manage");
    }

    @PostMapping("enable")
    public ModelAndView enableUser(UserBatchOperateParam batchOperationQuery) throws BusinessException {
        this.userService.enableUser(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/user/manage");
    }

    @PostMapping("disable")
    public ModelAndView disableUser(UserBatchOperateParam batchOperationQuery) throws BusinessException {
        this.userService.disableUser(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/user/manage");
    }
}