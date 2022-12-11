package com.sparrow.security.admin.protocol;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;

public enum SecurityErrorCode implements ErrorSupport {

    GROUP_NAME_IS_NUL(false, SecurityModule.GROUP, "01", "group name is empty"),
    ;

    private boolean system;
    private ModuleSupport module;
    private String code;
    private String message;

    private SecurityErrorCode(boolean system, ModuleSupport module, String code, String message) {
        this.system = system;
        this.message = message;
        this.module = module;
        this.code = (system ? 0 : 1) + module.code() + code;
    }

    public boolean system() {
        return this.system;
    }

    public ModuleSupport module() {
        return this.module;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
