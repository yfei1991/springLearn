package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_admin_site`")
public class CpCmsAdminSite implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 管理员id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 站点id
     */
    @Column(name = "`site_id`")
    private Integer siteId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员id
     *
     * @return user_id - 管理员id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置管理员id
     *
     * @param userId 管理员id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取站点id
     *
     * @return site_id - 站点id
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * 设置站点id
     *
     * @param siteId 站点id
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}