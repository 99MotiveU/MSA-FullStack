package com.my.sts;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.sts.model.DeptDao;
import com.my.sts.model.DeptVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	DeptDao deptDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info(deptDao.selectAll().toString());
		
		model.addAttribute("serverTime", deptDao.selectAll() );
		
		return "home";
	}
	
	@PostMapping("/")
	public ResponseEntity<?> add(@ModelAttribute DeptVo bean){
		logger.info(bean.toString());
		deptDao.insertOne(bean);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}












