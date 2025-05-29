package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class ForumParam implements Param {

    private String forumName;
    /**
     * 资源 ID
     */
    private Long resourceId;
    /**
     * 版块前台列表对应的url
     */
    private String listUrl;
    /**
     * 版块后台管理新建对应的url
     */
    private String newUrl;
    /**
     * 版块前台展示详情页对应url
     */
    private String detailUrl;
    /**
     * cms-{100}.do 访问的url placeholder
     * <p>
     * cms-manage.do?forumCode=100
     */
    private String placeholderUrl;
    /**
     * 上传的key 由文件上传服务提供
     */
    private String uploadKey;
    /**
     * 版块的封面图
     */
    private String cover;
    /**
     * 版本的管理员
     */
    private String manager;
    /**
     * 版块最大的记录数
     */
    private Integer maxRecordCount;
    private String status;
    private String remark;

}
