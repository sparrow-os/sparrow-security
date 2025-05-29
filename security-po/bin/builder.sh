if pwd | grep -q -E 'bin$'; then
    echo "true"
else
    echo "请cd到bin目录下运行"
    exit 1
fi
config_path=$(pwd)/config.properties
echo $config_path
sh ./coder.sh -ct com.sparrow.security.po.App -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.MicroService -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.Group -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.GroupRole -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.Role -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.RoleApp -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.User -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.UserGroup -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.UserRole -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.Department -config=$config_path
sh ./coder.sh -ct com.sparrow.security.po.RoleStrategy -config=$config_path















