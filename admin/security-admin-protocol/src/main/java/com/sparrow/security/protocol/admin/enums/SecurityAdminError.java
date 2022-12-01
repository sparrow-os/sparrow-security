package com.sparrow.security.protocol.admin.enums;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;

public enum SecurityAdminError implements ErrorSupport {

    GROUP_NAME_IS_EMPTY(false, SecurityModule.Group, "01", "group name is null"),
    GROUP_TYPE_IS_EMPTY(false, SecurityModule.Group, "02", "group type is null"),
    GROUP_ICON_EMPTY(false, SecurityModule.Group, "03", "group icon is null"),
    GROUP_ID_IS_EMPTY(false, SecurityModule.Group, "05", "group id is null"),

    RESOURCE_NAME_IS_EMPTY(false, SecurityModule.Resource, "01", "resource name is null"),
    RESOURCE_TYPE_IS_EMPTY(false, SecurityModule.Resource, "02", "resource type is null"),
    RESOURCE_ICON_EMPTY(false, SecurityModule.Resource, "03", "resource icon is null"),
    RESOURCE_PARENT_ID_IS_EMPTY(false, SecurityModule.Resource, "04", "resource parent id is null"),
    RESOURCE_ID_IS_EMPTY(false, SecurityModule.Resource, "05", "resource id is null"),
    RESOURCE_SORT_TARGET_IS_EMPTY(false, SecurityModule.Resource, "06", "resource sort target is null"),


    ;
    private boolean system;
    private ModuleSupport module;
    private String code;
    private String message;

    SecurityAdminError(boolean system, ModuleSupport module, String code, String message) {
        this.system = system;
        this.message = message;
        this.module = module;
        this.code = (system ? 0 : 1) + module.code() + code;
    }

    @Override
    public boolean system() {
        return this.system;
    }

    @Override
    public ModuleSupport module() {
        return this.module;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
