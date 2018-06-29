package com.starlightfinancial.springsecuritydemocsdn.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/28 16:05
 * @Modified By:
 */
public class SecurityUser extends SysUser implements UserDetails {

    private static final long serialVersionUID = 1682841366226363006L;

    public SecurityUser(SysUser sysUser) {
        if(sysUser != null)
        {
            this.setId(sysUser.getId());
            this.setName(sysUser.getName());
            this.setEmail(sysUser.getEmail());
            this.setPassword(sysUser.getPassword());
            this.setDob(sysUser.getDob());
            this.setSysRoles(sysUser.getSysRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> userRoles = this.getSysRoles();

        if(userRoles != null)
        {
            for (SysRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
