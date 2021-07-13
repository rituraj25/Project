package com.project.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.project.Dao.Userdao;
import com.project.project.entity.User;

@RestController
public class HomeController {

	@Autowired
	Userdao userdao;
	
	@GetMapping ("/")
	public ModelAndView validateUser() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("index");
	return mv;
	}
	
	@PostMapping ("/validate")
	public void validate (@ModelAttribute ("user") User user) {
		User user1=userdao.findByName(user.getName());
		System.out.print(user1);
	}

	
}
