package com.starlightfinancial.springsecuritydemocsdn.service;

import com.starlightfinancial.springsecuritydemocsdn.domain.SysUser;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/28 16:06
 * @Modified By:
 */
public interface UserService {
    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    SysUser findByName(String username);
}
