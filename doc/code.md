# 权限管理系统 - 国际化字典表结构设计

## 1. 设计原则

- **多租户隔离**: 所有字典数据均携带 `tenant_id`，支持租户级自定义字典
- **国际化分离**: 主表存储业务标识与逻辑值，i18n 表存储多语言展示文本，通过不可变 ID 关联
- **审计字段对齐**: 统一使用 TRD2 定义的 6 个审计字段（create_user_id, gmt_create, modified_user_id, gmt_modified, create_user_name, modified_user_name）
- **编码不可变**: `type_code` / `item_code` 创建后禁止修改，防止翻译断裂与缓存失效
- **策略枚举硬编码**: `strategy_input_type` / `visibility_scope` 等字典仅作前端 UI 渲染辅助，后端校验仍以代码 Enum 为准
- **缓存 Key**: `dict:{tenant_id}:{type_code}:{locale}`，修改时按 type_code 清除该租户下所有 locale 缓存

---

## 2. 表结构 DDL

### 2.1 t_dict_type（字典类型主表）

```sql
CREATE TABLE t_dict_type (
    id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    tenant_id       VARCHAR(64)  NOT NULL COMMENT '租户ID',
    type_code       VARCHAR(100) NOT NULL COMMENT '字典类型编码（不可变）',
    status          TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    sort_order      INT          NOT NULL DEFAULT 0 COMMENT '排序号',
    remark          VARCHAR(500) DEFAULT NULL COMMENT '备注',
    create_user_id   VARCHAR(64)  NOT NULL COMMENT '创建人ID',
    gmt_create       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_user_id VARCHAR(64)  DEFAULT NULL COMMENT '修改人ID',
    gmt_modified     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_user_name  VARCHAR(100) DEFAULT NULL COMMENT '创建人姓名',
    modified_user_name VARCHAR(100) DEFAULT NULL COMMENT '修改人姓名',
    PRIMARY KEY (id),
    UNIQUE KEY uk_tenant_type_code (tenant_id, type_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典类型主表';
```

### 2.2 t_dict_type_i18n（字典类型国际化表）

```sql
CREATE TABLE t_dict_type_i18n (
    id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    dict_type_id    BIGINT       NOT NULL COMMENT '关联 t_dict_type.id（不可变）',
    locale          VARCHAR(10)  NOT NULL COMMENT '语言标识（zh-CN/en-US/ja-JP等）',
    type_name       VARCHAR(200) NOT NULL COMMENT '字典类型显示名称',
    create_user_id   VARCHAR(64)  NOT NULL COMMENT '创建人ID',
    gmt_create       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_user_id VARCHAR(64)  DEFAULT NULL COMMENT '修改人ID',
    gmt_modified     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_user_name  VARCHAR(100) DEFAULT NULL COMMENT '创建人姓名',
    modified_user_name VARCHAR(100) DEFAULT NULL COMMENT '修改人姓名',
    PRIMARY KEY (id),
    UNIQUE KEY uk_type_locale (dict_type_id, locale)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典类型国际化表';
```

### 2.3 t_dict_item（字典项主表）

```sql
CREATE TABLE t_dict_item (
    id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    tenant_id       VARCHAR(64)  NOT NULL COMMENT '租户ID',
    dict_type_id    BIGINT       NOT NULL COMMENT '关联 t_dict_type.id',
    item_code       VARCHAR(100) NOT NULL COMMENT '字典项编码（不可变）',
    item_value      VARCHAR(500) DEFAULT NULL COMMENT '字典项值（存储实际业务值）',
    status          TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    sort_order      INT          NOT NULL DEFAULT 0 COMMENT '排序号',
    remark          VARCHAR(500) DEFAULT NULL COMMENT '备注',
    create_user_id   VARCHAR(64)  NOT NULL COMMENT '创建人ID',
    gmt_create       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_user_id VARCHAR(64)  DEFAULT NULL COMMENT '修改人ID',
    gmt_modified     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_user_name  VARCHAR(100) DEFAULT NULL COMMENT '创建人姓名',
    modified_user_name VARCHAR(100) DEFAULT NULL COMMENT '修改人姓名',
    PRIMARY KEY (id),
    UNIQUE KEY uk_tenant_type_item (tenant_id, dict_type_id, item_code),
    KEY idx_dict_type_id (dict_type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典项主表';
```

### 2.4 t_dict_item_i18n（字典项国际化表）

```sql
CREATE TABLE t_dict_item_i18n (
    id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    dict_item_id    BIGINT       NOT NULL COMMENT '关联 t_dict_item.id（不可变）',
    locale          VARCHAR(10)  NOT NULL COMMENT '语言标识（zh-CN/en-US/ja-JP等）',
    item_label      VARCHAR(200) NOT NULL COMMENT '字典项显示标签',
    create_user_id   VARCHAR(64)  NOT NULL COMMENT '创建人ID',
    gmt_create       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_user_id VARCHAR(64)  DEFAULT NULL COMMENT '修改人ID',
    gmt_modified     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    create_user_name  VARCHAR(100) DEFAULT NULL COMMENT '创建人姓名',
    modified_user_name VARCHAR(100) DEFAULT NULL COMMENT '修改人姓名',
    PRIMARY KEY (id),
    UNIQUE KEY uk_item_locale (dict_item_id, locale)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典项国际化表';
```

---

## 3. 预置字典清单

| type_code           | 说明             | 典型 item_code 示例                              | 备注                     |
|---------------------|------------------|--------------------------------------------------|--------------------------|
| permission_type     | 权限类型         | menu, button, api                                | RBAC 核心                |
| common_status       | 通用状态         | enabled, disabled                                | 全局复用                 |
| http_method         | HTTP 请求方法    | GET, POST, PUT, DELETE, PATCH                    | API 权限绑定             |
| open_type           | 开放类型         | public, private, internal                        | 接口可见性               |
| member_type         | 成员类型         | user, role, dept                                 | 授权对象分类             |
| strategy_input_type | 策略输入类型     | string, number, boolean, enum, list              | 仅 UI 渲染，后端 Enum 校验 |
| visibility_scope    | 可见范围         | all, self, dept, custom                          | 仅 UI 渲染，后端 Enum 校验 |
| audit_action        | 审计操作类型     | login, logout, create, update, delete, export    | 操作日志分类             |

---

## 4. 缓存策略

- **Key 格式**: `dict:{tenant_id}:{type_code}:{locale}`
- **过期策略**: TTL 30 分钟 + 主动失效
- **失效触发**: 字典类型/字典项增删改时，删除该租户下对应 `type_code` 的所有 locale 缓存
- **降级方案**: 缓存未命中时查库并回填，避免缓存穿透加布隆过滤器或空值短 TTL

---

## 5. 后续待办

1. [ ] 编写初始化 SQL 脚本（预置字典数据 + zh-CN/en-US 双语翻译）
2. [ ] RBAC 服务实现字典缓存模块
3. [ ] 后台管理界面增加"字典管理"模块（type_code/item_code 创建后置灰禁编辑）
4. [ ] 各业务表枚举字段逐步迁移为存 item_code，通过字典服务获取展示名称
