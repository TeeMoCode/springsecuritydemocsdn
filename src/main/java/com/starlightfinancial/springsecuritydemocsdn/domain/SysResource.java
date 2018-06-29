package com.starlightfinancial.springsecuritydemocsdn.domain;

import javax.persistence.*;

/**
 * @author: Senlin.Deng
 * @Description:
 * @date: Created in 2018/6/25 16:41
 * @Modified By:
 */
@Entity
@Table(name="s_resource")
public class SysResource {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private int id;

    /**
     * url
     */
    @Column(name="resourceString",length=1000)
    private String resourceString;

    /**
     * 资源ID
     */
    @Column(name="resourceId",length=50)
    private String resourceId;

    /**
     * 备注
     */
    @Column(name="remark",length=200)
    private String remark;

    /**
     *  资源名称
     */
    @Column(name="resourceName",length=400)
    private String resourceName;

    /**
     * 资源所对应的方法名
     */
    @Column(name="methodName",length=400)
    private String methodName;

    @Column(name="methodPath",length=1000)
    private String methodPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }

}
