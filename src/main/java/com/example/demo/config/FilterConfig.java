package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.AccessControlFilter;
import com.example.demo.filter.AuthFilter;
/**
 * @author   czq
 * @Date 2020-06-23 13:35:46    
 */
@Configuration
public class FilterConfig {

	/**
	 * 控制请求的来源种类
	 * @return
	 */
	@Bean
    public FilterRegistrationBean<AccessControlFilter> accessControlFilter() {
        FilterRegistrationBean<AccessControlFilter> registrationBean = new FilterRegistrationBean<AccessControlFilter>();
        AccessControlFilter accessControlFilter = new AccessControlFilter();
        registrationBean.setOrder(1);
        registrationBean.setFilter(accessControlFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
	
	@Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<AuthFilter>();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setOrder(2);
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns("/hello/*", "/mms/application/*", "/mms/export/*", "/mms/history/*", "/mms/host/*", "/mms/hostgroup/*", "/mms/import/*", "/mms/infoe/*",
                "/mms/item/*", "/mms/maintenance/*", "/mms/problem/*", "/mms/template/*", "/mms/trigger/*");
        return registrationBean;
    }
}
