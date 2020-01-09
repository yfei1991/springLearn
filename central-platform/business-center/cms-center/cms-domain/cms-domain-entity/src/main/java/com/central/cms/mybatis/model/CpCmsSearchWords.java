package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_search_words`")
public class CpCmsSearchWords implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 搜索词汇
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 搜索次数
     */
    @Column(name = "`hit_count`")
    private Integer hitCount;

    /**
     * 推荐
     */
    @Column(name = "`is_recommend`")
    private Boolean isRecommend;

    /**
     * 站点
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
     * 获取搜索词汇
     *
     * @return name - 搜索词汇
     */
    public String getName() {
        return name;
    }

    /**
     * 设置搜索词汇
     *
     * @param name 搜索词汇
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取搜索次数
     *
     * @return hit_count - 搜索次数
     */
    public Integer getHitCount() {
        return hitCount;
    }

    /**
     * 设置搜索次数
     *
     * @param hitCount 搜索次数
     */
    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    /**
     * 获取推荐
     *
     * @return is_recommend - 推荐
     */
    public Boolean getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置推荐
     *
     * @param isRecommend 推荐
     */
    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取站点
     *
     * @return site_id - 站点
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * 设置站点
     *
     * @param siteId 站点
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}