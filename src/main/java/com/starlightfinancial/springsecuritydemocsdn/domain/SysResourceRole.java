package com.starlightfinancial.springsecuritydemocsdn.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/26 10:02
 * @Modified By:
 */
@Entity
@Table(name="s_resource_role")
public class SysResourceRole {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private int id;


    /**
     * 角色ID
     */
    @Column(name="roleId",length=50)
    private String roleId;

    /**
     * 资源ID
     */
    @Column(name="resourceId",length=50)
    private String resourceId;

    /**
     * 更新时间
     */
    @Column(name="updateTime")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
