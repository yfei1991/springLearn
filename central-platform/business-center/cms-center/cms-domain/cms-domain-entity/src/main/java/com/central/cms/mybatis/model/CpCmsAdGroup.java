package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_ad_group`")
public class CpCmsAdGroup implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`group_name`")
    private String groupName;

    @Column(name = "`status`")
    private Boolean status;

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
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
}