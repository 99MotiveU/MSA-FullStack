package com.my.sts.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Value("${msg}")
	String msg;

	@GetMapping("")
	public String index() {return "index";}
	
	@GetMapping("intro")
	public void intro(Model model) {
		model.addAttribute("msg",msg);
	}
	
	@GetMapping("/login/")
	public String login(HttpSession session) {
		System.out.println(session.getId());
		return "login/login";
	}
	
	@GetMapping("/upload")
	public String form() {
		return "file";
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(String name,MultipartFile[] file) throws IOException{
		System.out.println(name);
		for(MultipartFile f : file) {
			System.out.println(f.getOriginalFilename());
			System.out.println(Arrays.toString(f.getBytes()));
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}













