package com.example.demo.entity;
/**
 * @author   czq
 * @Date 2020-06-23 13:02:39    
 */
public class LoginUserInfo {

	private String token;

    private Long userId;

    private String loginName;

    private String lastLoginTime;

    private String lastLoginIp;

    private String lastLoginAgent;

    private String lastLoginMac;

    private String userName;

    private String userEmail;

    private String userMobile;

    private Long roleId;

    private String roleName;

    private Long passwordStamp;

    private Boolean passwordExpire;

    ////
    private String remark;

    private String createDt;

    private String updateDt;

    private Integer deleted;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAgent() {
        return lastLoginAgent;
    }

    public void setLastLoginAgent(String lastLoginAgent) {
        this.lastLoginAgent = lastLoginAgent;
    }

    public String getLastLoginMac() {
        return lastLoginMac;
    }

    public void setLastLoginMac(String lastLoginMac) {
        this.lastLoginMac = lastLoginMac;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getPasswordStamp() {
        return passwordStamp;
    }

    public void setPasswordStamp(Long passwordStamp) {
        this.passwordStamp = passwordStamp;
    }

    public Boolean getPasswordExpire() {
        return passwordExpire;
    }

    public void setPasswordExpire(Boolean passwordExpire) {
        this.passwordExpire = passwordExpire;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

	@Override
	public String toString() {
		return "LoginUserInfo [token=" + token + ", userId=" + userId + ", loginName=" + loginName + ", lastLoginTime="
				+ lastLoginTime + ", lastLoginIp=" + lastLoginIp + ", lastLoginAgent=" + lastLoginAgent
				+ ", lastLoginMac=" + lastLoginMac + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userMobile=" + userMobile + ", roleId=" + roleId + ", roleName=" + roleName + ", passwordStamp="
				+ passwordStamp + ", passwordExpire=" + passwordExpire + ", remark=" + remark + ", createDt=" + createDt
				+ ", updateDt=" + updateDt + ", deleted=" + deleted + "]";
	}
    
    
}
