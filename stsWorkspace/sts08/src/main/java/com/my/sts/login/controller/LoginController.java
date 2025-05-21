package com.my.sts.login.controller;

import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/")
public class LoginController {

	@GetMapping("")
	public ResponseEntity<String> login(HttpSession session,HttpServletResponse res){
		System.out.println(session.getId());
		Cookie cookie=new Cookie("hello", "world");
		res.addCookie(cookie);
		return new ResponseEntity<String>("result",HttpStatus.OK);
	}
	@GetMapping("logout")
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>("result",HttpStatus.OK);
	}
}










