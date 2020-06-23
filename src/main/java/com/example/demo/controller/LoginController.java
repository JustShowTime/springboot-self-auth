package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginUserInfo;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.vo.req.LoginReqVo;

/**
 * @author czq
 * @Date 2020-06-23 11:52:30
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private LoginService loginService;

	/**
	 * 1.认证：（确认账号，密码正确） 2.生成token，放入缓存中
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void login(@RequestBody LoginReqVo loginReqVo) {
		// 校验请求参数
		loginService.checkLoginReqVo(loginReqVo);
		String loginName = loginReqVo.getLoginName();
		String password = loginReqVo.getPassword();
		System.out.println("参数校验成功");

		// 用户名 密码 校验
		String remoteAddr = request.getRemoteAddr();
		User user = loginService.checkLogin(loginName, password, remoteAddr);
		System.out.println("用户，密码校验成功");
		
		// 生成 token
		LoginUserInfo loginUserInfo = loginService.generateToken(user);
        // 更新登录状态,就是修改ip，浏览器等参数
        loginService.updateUserLogin(request, user);
	}
	
	
}
