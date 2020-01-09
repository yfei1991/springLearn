package com.central.cms.mybatis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`cp_cms_admin`")
public class CpCmsAdmin implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 登陆时间
     */
    @Column(name = "`login_time`")
    private Date loginTime;

    /**
     * 离开时间
     */
    @Column(name = "`logout_time`")
    private Date logoutTime;

    /**
     * 登陆IP
     */
    @Column(name = "`last_ip`")
    private String lastIp;

    /**
     * 管理员状态
     */
    @Column(name = "`status`")
    private Boolean status;

    /**
     * 管理员说明
     */
    @Column(name = "`des`")
    private String des;

    /**
     * 用户头像
     */
    @Column(name = "`avatar`")
    private String avatar;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户创建时间
     *
     * @return create_time - 用户创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置用户创建时间
     *
     * @param createTime 用户创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取登陆时间
     *
     * @return login_time - 登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登陆时间
     *
     * @param loginTime 登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取离开时间
     *
     * @return logout_time - 离开时间
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 设置离开时间
     *
     * @param logoutTime 离开时间
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 获取登陆IP
     *
     * @return last_ip - 登陆IP
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置登陆IP
     *
     * @param lastIp 登陆IP
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取管理员状态
     *
     * @return status - 管理员状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置管理员状态
     *
     * @param status 管理员状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取管理员说明
     *
     * @return des - 管理员说明
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置管理员说明
     *
     * @param des 管理员说明
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取用户头像
     *
     * @return avatar - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}