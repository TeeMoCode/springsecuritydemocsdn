package com.starlightfinancial.springsecuritydemocsdn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/25 16:31
 * @Modified By:
 */
@Entity
@Table(name = "s_user")
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", length = 120)

    /**
     * 用户名
     */
    private String name;
    @Column(name = "email", length = 50)

    /**
     *   用户邮箱
     */
    private String email;


    /**
     * 用户密码
     */
    @Column(name = "password", length = 120)
    private String password;


    /**
     * 时间
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;

    /**
     * 所对应的角色集合
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysUser")
    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);

    public SysUser() {
    }

    public SysUser(String name, String email, String password, Date dob, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.SysRoles = SysRoles;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysUser")

    public Set<SysRole> getSysRoles() {
        return SysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        SysRoles = sysRoles;
    }
}
