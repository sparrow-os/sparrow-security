#!/bin/bash
set -euo pipefail

# ============================================================
# sparrow-security 上线初始化脚本
# 用法:
#   1) 与 sparrow-security-release.sql 放在同一目录
#   2) 修改下方数据库配置（或用环境变量覆盖）
#   3) 执行:  bash release.sh
#
# 注意: 本脚本会 DROP 并重建 13 张表，仅用于首次上线/清库初始化。
# ============================================================

DB_HOST="${DB_HOST:-127.0.0.1}"
DB_PORT="${DB_PORT:-3306}"
DB_USER="${DB_USER:-root}"
DB_NAME="${DB_NAME:-sparrow}"

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
SQL_FILE="$SCRIPT_DIR/sparrow-security-release.sql"

if [ ! -f "$SQL_FILE" ]; then
  echo "错误: 找不到 $SQL_FILE" >&2
  echo "请确认 sparrow-security-release.sql 与本脚本在同一目录。" >&2
  exit 1
fi

echo "======================================================"
echo " sparrow-security 上线初始化"
echo " 目标库: ${DB_USER}@${DB_HOST}:${DB_PORT}/${DB_NAME}"
echo " 脚本:   ${SQL_FILE}"
echo " 警告:   将 DROP 并重建 13 张表（仅首次上线使用）"
echo "======================================================"

if [ -n "${DB_PASSWORD:-}" ]; then
  sed "s/\`sparrow\`/\`${DB_NAME}\`/g" "$SQL_FILE" | \
    MYSQL_PWD="$DB_PASSWORD" mysql -h"$DB_HOST" -P"$DB_PORT" -u"$DB_USER" \
      --default-character-set=utf8mb4
else
  sed "s/\`sparrow\`/\`${DB_NAME}\`/g" "$SQL_FILE" | \
    mysql -h"$DB_HOST" -P"$DB_PORT" -u"$DB_USER" -p \
      --default-character-set=utf8mb4
fi

echo "==> 执行完成"
