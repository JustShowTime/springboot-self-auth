package com.example.demo.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.LoginUserInfo;
import com.example.demo.utils.TokenUtil;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// token 不能为空
		String token = request.getHeader("Token");
		if (!StringUtils.hasText(token)) {
			int code = HttpStatus.UNAUTHORIZED.value();
			String retString = JSON.toJSONString(Collections.singletonMap("msg", "[token]为空"));
			writeJSON(response, code, retString);
			return;
		}

		// 用户认证, 鉴权
		String uri = request.getRequestURI();
		String method = request.getMethod().toUpperCase();

		// token 存活检查
		String jsonString = TokenUtil.get(token);
		if (jsonString == null) {
			int code = HttpStatus.UNAUTHORIZED.value();
			String retString = JSON.toJSONString(Collections.singletonMap("msg", "[Token]过期, 请重新登录"));
			writeJSON(response, code, retString);
			return;
		}

		// token 内容解析 = 用户认证
		Long userId = JSON.parseObject(jsonString).getLong("userId");
        LoginUserInfo loginUserInfo = JSON.parseObject(jsonString).getObject("userInfo", LoginUserInfo.class);
        System.out.println("用户认证通过");
        
		
		// 用户鉴权
        System.out.println("用户鉴权通过");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	private void writeJSON(HttpServletResponse response, int code, String jsonString) throws IOException {
		response.setStatus(code);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(jsonString);
		writer.flush();
		writer.close();
	}

}
