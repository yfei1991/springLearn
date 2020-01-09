package com.central.cms.mybatis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`cp_cms_ad_silder`")
public class CpCmsAdSilder implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`silde_name`")
    private String sildeName;

    @Column(name = "`img`")
    private String img;

    @Column(name = "`silde_url`")
    private String sildeUrl;

    @Column(name = "`sort_id`")
    private Integer sortId;

    @Column(name = "`status`")
    private Boolean status;

    @Column(name = "`start_date`")
    private Date startDate;

    @Column(name = "`end_date`")
    private Date endDate;

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
     * @return silde_name
     */
    public String getSildeName() {
        return sildeName;
    }

    /**
     * @param sildeName
     */
    public void setSildeName(String sildeName) {
        this.sildeName = sildeName;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return silde_url
     */
    public String getSildeUrl() {
        return sildeUrl;
    }

    /**
     * @param sildeUrl
     */
    public void setSildeUrl(String sildeUrl) {
        this.sildeUrl = sildeUrl;
    }

    /**
     * @return sort_id
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * @param sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}