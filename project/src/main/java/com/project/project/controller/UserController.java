package com.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.project.Dao.CategoryDao;
import com.project.project.Dao.ProductDao;
import com.project.project.entity.Product;

@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired 
	CategoryDao categorydao;
	
	@Autowired
	ProductDao productdao;
	
	@GetMapping("/products")
	public ModelAndView showProducts() {
		ModelAndView mv=new ModelAndView();
		List<Product>product= productdao.findAll();
		mv.addObject("product",product);
		mv.setViewName("products");
		return mv;
	}
}
