package com.example.demo.vo.req;

/**
 * @author   czq
 * @Date 2020-06-23 12:00:06    
 */
public class LoginReqVo {

    private String loginName;

    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "LoginReqVo [loginName=" + loginName + ", password=" + password + "]";
	}


    
}
