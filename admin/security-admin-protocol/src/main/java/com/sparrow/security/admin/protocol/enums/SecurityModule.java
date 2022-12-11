package com.sparrow.security.admin.protocol.enums;

import com.sparrow.protocol.ModuleSupport;

public class SecurityModule {
    public static final ModuleSupport Group = new ModuleSupport() {
        @Override
        public String code() {
            return "31";
        }

        @Override
        public String name() {
            return "Group";
        }
    };

    public static final ModuleSupport Resource = new ModuleSupport() {
        @Override
        public String code() {
            return "41";
        }

        @Override
        public String name() {
            return "Resource";
        }
    };

    public static final ModuleSupport Role = new ModuleSupport() {
        @Override
        public String code() {
            return "51";
        }

        @Override
        public String name() {
            return "Role";
        }
    };

    public static final ModuleSupport Forum = new ModuleSupport() {
        @Override
        public String code() {
            return "61";
        }

        @Override
        public String name() {
            return "Forum";
        }
    };
}
