package com.example.demo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.controller.other.ParameterValidator;
import com.example.demo.entity.LoginUserInfo;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.utils.LocalDateTimeUtil;
import com.example.demo.utils.SystemUtil;
import com.example.demo.utils.TokenUtil;
import com.example.demo.vo.req.LoginReqVo;

/**
 * @author czq
 * @Date 2020-06-23 12:07:16
 */
@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * 1.非空校验 2.长度校验
	 */
	@Override
	public void checkLoginReqVo(LoginReqVo vo) {
		// TODO Auto-generated method stub
		String loginName = vo.getLoginName();
		String password = vo.getPassword();
		ParameterValidator.validLoginName(loginName, false);
		ParameterValidator.validPassword(password, false);
	}

	@Override
	public LoginUserInfo generateToken(User user) {
		// 生成token
		String token = String.valueOf(SystemUtil.nextId());
		System.out.println("token: "+token);

		// 存入缓存
		LoginUserInfo userInfo = JSON.parseObject(JSON.toJSONString(user), LoginUserInfo.class);
		JSONObject map = new JSONObject();
		map.put("userId", user.getUserId());
		map.put("userInfo", userInfo);
		TokenUtil.put(token, map.toJSONString());

		return userInfo;

	}

	@Override
	public User checkLogin(String loginName, String password, String remoteAddr) {
		// 入库查询，
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPassword(password);
		user.setLastLoginIp(remoteAddr);
		return user;
	}

	@Override
	public int updateUserLogin(HttpServletRequest request, User user) {
		user.setLastLoginTime(LocalDateTimeUtil.now());
		user.setLastLoginAgent(request.getHeader("user-agent"));
		user.setLastLoginIp(request.getHeader("x-real-ip"));
		
		//更新数据库
		return 1;
	}

}
