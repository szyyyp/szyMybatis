package com.bupt.config;


import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        //从数据库获取用户
        //User staff = ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加角色
        //info.addRole(staff.getCurWorkGroup());
        //添加用户包含的功能
        /*
        List<Function> functions = workGroupService.selectWorkGroupFunction(staff.getCurWorkGroupId());
        for(int i = 0 ; i<functions.size();i++){
            info.addStringPermission(functions.get(i).getFunctionName());
        }

         */
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //数据库获取用户
        //User user = userService.selectUserByUsername(userToken.getUsername());
        //if(staff == null){
            //return null;
        //}
        //返回用户名和用户密码
        //return new SimpleAuthenticationInfo(staff.getUsername(),staff.getPassword(),"");
        return null;
    }
}
