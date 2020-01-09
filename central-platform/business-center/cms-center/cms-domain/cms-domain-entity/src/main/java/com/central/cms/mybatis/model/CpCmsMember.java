package com.central.cms.mybatis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`cp_cms_member`")
public class CpCmsMember implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "`member_id`")
    private Integer memberId;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 用户密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 电子邮件
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 联系人
     */
    @Column(name = "`linkman`")
    private String linkman;

    /**
     * 手机号
     */
    @Column(name = "`mobile`")
    private String mobile;

    /**
     * 用户状态
     */
    @Column(name = "`status`")
    private Boolean status;

    /**
     * 用户登陆ip
     */
    @Column(name = "`ip`")
    private String ip;

    /**
     * 上次登陆时间
     */
    @Column(name = "`last_time`")
    private Date lastTime;

    /**
     * 用户密码加密盐
     */
    @Column(name = "`salt`")
    private String salt;

    /**
     * （0为个人用户，1为企业）
     */
    @Column(name = "`user_type`")
    private Integer userType;

    /**
     * 分组id
     */
    @Column(name = "`level_id`")
    private Integer levelId;

    /**
     * 用户积分
     */
    @Column(name = "`integral`")
    private Integer integral;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return member_id - 用户id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置用户id
     *
     * @param memberId 用户id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系人
     *
     * @return linkman - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户状态
     *
     * @return status - 用户状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取用户登陆ip
     *
     * @return ip - 用户登陆ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置用户登陆ip
     *
     * @param ip 用户登陆ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取上次登陆时间
     *
     * @return last_time - 上次登陆时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置上次登陆时间
     *
     * @param lastTime 上次登陆时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取用户密码加密盐
     *
     * @return salt - 用户密码加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置用户密码加密盐
     *
     * @param salt 用户密码加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取（0为个人用户，1为企业）
     *
     * @return user_type - （0为个人用户，1为企业）
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置（0为个人用户，1为企业）
     *
     * @param userType （0为个人用户，1为企业）
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取分组id
     *
     * @return level_id - 分组id
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * 设置分组id
     *
     * @param levelId 分组id
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取用户积分
     *
     * @return integral - 用户积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置用户积分
     *
     * @param integral 用户积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}