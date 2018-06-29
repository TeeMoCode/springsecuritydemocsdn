package com.starlightfinancial.springsecuritydemocsdn.service.impl;

import com.starlightfinancial.springsecuritydemocsdn.domain.SysUser;
import com.starlightfinancial.springsecuritydemocsdn.domain.SysUserRepository;
import com.starlightfinancial.springsecuritydemocsdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/28 16:07
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser findByName(String username) {
        return sysUserRepository.findByName(username);
    }


}
