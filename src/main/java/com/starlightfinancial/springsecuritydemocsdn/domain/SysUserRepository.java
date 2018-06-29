package com.starlightfinancial.springsecuritydemocsdn.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/28 16:07
 * @Modified By:
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    SysUser findByName(String username);
}
