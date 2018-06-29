package com.starlightfinancial.springsecuritydemocsdn.security.userdetails;

import com.starlightfinancial.springsecuritydemocsdn.domain.SecurityUser;
import com.starlightfinancial.springsecuritydemocsdn.domain.SysUser;
import com.starlightfinancial.springsecuritydemocsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/28 15:54
 * @Modified By:
 */
@Component
public class CustomUserDetailsService  implements UserDetailsService {
    @Autowired  //业务服务类
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SysUser中的name作为用户名:
        SysUser user = userService.findByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser seu = new SecurityUser(user);
        return  seu;
    }

}
