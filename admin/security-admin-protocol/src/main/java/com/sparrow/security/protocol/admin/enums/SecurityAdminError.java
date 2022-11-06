package com.sparrow.security.protocol.admin.enums;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;

public enum SecurityAdminError implements ErrorSupport {

    GROUP_NAME_IS_EMPTY(false, SecurityModule.Group, "01", "group name is null"),
    GROUP_TYPE_IS_EMPTY(false, SecurityModule.Group, "02", "group type is null"),
    GROUP_NAME_ICON_EMPTY(false, SecurityModule.Group, "03", "group icon is null"),
    GROUP_PARENT_ID_IS_EMPTY(false, SecurityModule.Group, "04", "group parent id is null"),
    GROUP_ID_IS_EMPTY(false, SecurityModule.Group, "05", "group id is null"),

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
