package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czq
 * @Date 2020-06-23 11:52:30
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	/**
	 * 1.认证：（确认账号，密码正确） 2.生成token，放入缓存中
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		System.out.println("hello world");
		return "hello world";
	}

}
