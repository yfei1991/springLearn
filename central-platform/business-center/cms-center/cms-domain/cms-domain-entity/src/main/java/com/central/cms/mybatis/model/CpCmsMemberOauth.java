package com.central.cms.mybatis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`cp_cms_member_oauth`")
public class CpCmsMemberOauth implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`member_id`")
    private Integer memberId;

    @Column(name = "`oauth_openid`")
    private String oauthOpenid;

    @Column(name = "`oauth_name`")
    private String oauthName;

    @Column(name = "`nickname`")
    private String nickname;

    @Column(name = "`avatar`")
    private String avatar;

    @Column(name = "`login_time`")
    private Long loginTime;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`oauth_type`")
    private String oauthType;

    @Column(name = "`oauth_data`")
    private String oauthData;

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
     * @return member_id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * @return oauth_openid
     */
    public String getOauthOpenid() {
        return oauthOpenid;
    }

    /**
     * @param oauthOpenid
     */
    public void setOauthOpenid(String oauthOpenid) {
        this.oauthOpenid = oauthOpenid;
    }

    /**
     * @return oauth_name
     */
    public String getOauthName() {
        return oauthName;
    }

    /**
     * @param oauthName
     */
    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return login_time
     */
    public Long getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return oauth_type
     */
    public String getOauthType() {
        return oauthType;
    }

    /**
     * @param oauthType
     */
    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    /**
     * @return oauth_data
     */
    public String getOauthData() {
        return oauthData;
    }

    /**
     * @param oauthData
     */
    public void setOauthData(String oauthData) {
        this.oauthData = oauthData;
    }
}