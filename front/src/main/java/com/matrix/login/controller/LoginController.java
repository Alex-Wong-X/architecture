package com.matrix.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matrix.customer.mng.service.ICustomerService;
import com.matrix.customer.mng.vo.CustomerModel;

@Controller
@RequestMapping(value="/")
public class LoginController {
	@Autowired
	private ICustomerService service;
	
	@RequestMapping(value="/")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String login(@RequestParam("customerId")String customerId,
			@RequestParam("pwd")String pwd, HttpServletResponse response){
		
		if(customerId == null || customerId.trim().length() == 0){
			return "login";
		}
		
		CustomerModel cm = service.getByCustomerId(customerId);
		
		if(cm == null || cm.getUuid() <= 0){
			return "login";
		}
		
		Cookie cookie = new Cookie("login",cm.getUuid()+","+System.currentTimeMillis());
		response.addCookie(cookie);
		return "redirect:/toIndex";
	}
}
