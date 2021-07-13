package com.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.project.Dao.ProductDao;
import com.project.project.Dao.Userdao;
import com.project.project.entity.Product;
import com.project.project.entity.User;

@RestController
public class HomeController {

	@Autowired
	Userdao userdao;
	
	@Autowired 
	ProductDao productdao;
	
	@GetMapping ("/")
	public ModelAndView validateUser() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("index");
	return mv;
	}
	
	@PostMapping ("/validate")
	public ModelAndView validate (@ModelAttribute ("user") User user) {
		User user1=userdao.findByName(user.getName());
		ModelAndView mv=new ModelAndView();
		if (user1==null) {
			System.out.println("User dosent exist");
			mv.setViewName("index");
		}
		else {
			if (user1.getPassword().equals(user.getPassword())){
				System.out.println("LogedIn");
				List<Product>product= productdao.findAll();
				mv.addObject("product",product);
				mv.setViewName("products");
			}
			else {
				System.out.println("wrong password");
				mv.setViewName("index");
			}
		}
		return mv;
	}

	
}
