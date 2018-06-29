package com.starlightfinancial.springsecuritydemocsdn.domain;

import javax.persistence.*;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/25 16:32
 * @Modified By:
 */
@Entity
@Table(name = "s_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private int id;

    /**
     * 角色对应的用户实体
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private SysUser sysUser;

    /**
     * 角色名称
     */
    @Column(name = "name", length = 100)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
