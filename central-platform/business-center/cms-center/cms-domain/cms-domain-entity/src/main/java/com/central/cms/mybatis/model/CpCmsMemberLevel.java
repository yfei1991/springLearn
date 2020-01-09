package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_member_level`")
public class CpCmsMemberLevel implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`level_name`")
    private String levelName;

    @Column(name = "`is_default`")
    private Boolean isDefault;

    /**
     * 描述
     */
    @Column(name = "`desc`")
    private String desc;

    @Column(name = "`level_credit`")
    private Integer levelCredit;

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
     * @return level_name
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * @return is_default
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取描述
     *
     * @return desc - 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述
     *
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return level_credit
     */
    public Integer getLevelCredit() {
        return levelCredit;
    }

    /**
     * @param levelCredit
     */
    public void setLevelCredit(Integer levelCredit) {
        this.levelCredit = levelCredit;
    }
}