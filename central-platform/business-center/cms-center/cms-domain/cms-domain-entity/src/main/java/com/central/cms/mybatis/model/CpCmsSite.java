package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_site`")
public class CpCmsSite implements Serializable {
    /**
     * 站点id（0为主站，不能删除）
     */
    @Id
    @Column(name = "`site_id`")
    private Integer siteId;

    /**
     * 站点名称
     */
    @Column(name = "`site_name`")
    private String siteName;

    /**
     * 域名
     */
    @Column(name = "`domain`")
    private String domain;

    /**
     * 语言
     */
    @Column(name = "`language`")
    private String language;

    /**
     * 模板
     */
    @Column(name = "`template`")
    private String template;

    @Column(name = "`title`")
    private String title;

    /**
     * 关键字
     */
    @Column(name = "`keyword`")
    private String keyword;

    /**
     * 移动是否开启
     */
    @Column(name = "`is_mobile`")
    private Boolean isMobile;

    /**
     * 手机模板
     */
    @Column(name = "`mobile_tpl`")
    private String mobileTpl;

    /**
     * 站点状态
     */
    @Column(name = "`status`")
    private Boolean status;

    @Column(name = "`logo`")
    private String logo;

    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;

    private static final long serialVersionUID = 1L;

    /**
     * 获取站点id（0为主站，不能删除）
     *
     * @return site_id - 站点id（0为主站，不能删除）
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * 设置站点id（0为主站，不能删除）
     *
     * @param siteId 站点id（0为主站，不能删除）
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     * 获取站点名称
     *
     * @return site_name - 站点名称
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 设置站点名称
     *
     * @param siteName 站点名称
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 获取域名
     *
     * @return domain - 域名
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 设置域名
     *
     * @param domain 域名
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 获取语言
     *
     * @return language - 语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言
     *
     * @param language 语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取模板
     *
     * @return template - 模板
     */
    public String getTemplate() {
        return template;
    }

    /**
     * 设置模板
     *
     * @param template 模板
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取关键字
     *
     * @return keyword - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置关键字
     *
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取移动是否开启
     *
     * @return is_mobile - 移动是否开启
     */
    public Boolean getIsMobile() {
        return isMobile;
    }

    /**
     * 设置移动是否开启
     *
     * @param isMobile 移动是否开启
     */
    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    /**
     * 获取手机模板
     *
     * @return mobile_tpl - 手机模板
     */
    public String getMobileTpl() {
        return mobileTpl;
    }

    /**
     * 设置手机模板
     *
     * @param mobileTpl 手机模板
     */
    public void setMobileTpl(String mobileTpl) {
        this.mobileTpl = mobileTpl;
    }

    /**
     * 获取站点状态
     *
     * @return status - 站点状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置站点状态
     *
     * @param status 站点状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}