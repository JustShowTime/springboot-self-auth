package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.entity.LoginUserInfo;
import com.example.demo.entity.User;
import com.example.demo.vo.req.LoginReqVo;

/**
 * @author czq
 * @Date 2020-06-23 12:06:10
 */
public interface LoginService {
	void checkLoginReqVo(LoginReqVo loginReqVo);
	
	LoginUserInfo generateToken(User user);
	
	User checkLogin(String loginName, String password, String remoteAddr);
	
	int updateUserLogin(HttpServletRequest request, User user);
}
