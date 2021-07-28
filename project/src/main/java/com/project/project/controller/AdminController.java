package com.project.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.project.Dao.CategoryDao;
import com.project.project.Dao.OrderDao;
import com.project.project.Dao.ProductDao;
import com.project.project.Dao.SubCategoryDao;
import com.project.project.entity.Category;
import com.project.project.entity.Order;
import com.project.project.entity.Product;
import com.project.project.entity.SubCategory;
@Controller

public class AdminController {

	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	SubCategoryDao subcategorydao;
	
	@Autowired
	ProductDao productdao;
	
	@Autowired 
	OrderDao orderDao;
	
	@GetMapping ("/try")
	public String test() {
		return "test";
	}
	
	@GetMapping ("/category")
	public ModelAndView getallCategory() {
		ModelAndView mv= new ModelAndView ();
		List <Category>category =categorydao.findAll();
		mv.addObject("cat",category);
		//System.out.print(category);
		mv.addObject("cate",new Category());
		mv.setViewName("categorypage");
		System.out.println(mv);
		return mv;
	}
	@GetMapping ("/category/{id}")
	public ModelAndView getCategory(@PathVariable int id) {
		
		List <SubCategory>sub=subcategorydao.findAllByCategoryId( id);
		
		ModelAndView mv= new ModelAndView ();
		mv.addObject("subCat",sub);
		mv.addObject("cat_id",id);
		System.out.print(id);
		mv.setViewName("subCategory");
		return mv;
	}
	@GetMapping ("/deleteCategory/{id}")
	public ModelAndView deleteCategory(@PathVariable int id) {
		categorydao.deleteById(id);;
		return getallCategory();
	}
	@GetMapping("/productlist/{id}")
	public ModelAndView getproductlist(@PathVariable int id) {
		ModelAndView mv=new ModelAndView();
		List<Product> pr= productdao.findAllBySubCategoryId(id);
		mv.addObject("product",pr);
		mv.setViewName("productlist");
		return mv;
	}
	
	@PostMapping ("/addCat")
	public ModelAndView saveCategory(@ModelAttribute("category") @Valid Category category,
			 BindingResult result) throws Exception {
		ModelAndView mv=new ModelAndView();
		
		if (result.hasErrors()) {
		mv.setViewName("addCategoryForm");
		return mv;
		}
		Category cat=categorydao.save(category);
		System.out.print((cat));
		return getallCategory();
		
	}
	
	@GetMapping ("/addCategory")
	public String addCategory (Model model) {
		model.addAttribute("category", new Category());
		
		return "addCategoryForm" ;
	}
	@GetMapping ("/addSubcategory/{cat_id}")
	public ModelAndView saveSubCategory(@PathVariable int cat_id) {
		System.out.print("in add sub category");
		SubCategory subCat=new SubCategory();
		ModelAndView mv=new ModelAndView ();
		mv.addObject("pub",cat_id);
		mv.addObject("subCat",subCat);
		mv.setViewName("addsubCat");
		return mv;
	}
	
	@PostMapping ("/saveSubCat/{cat_id}")
	public ModelAndView saveSubcat(@ModelAttribute ("subCat") SubCategory subCat, @PathVariable int cat_id ) {
		Category cat=new Category();
		cat=categorydao.getById(cat_id);
		subCat.setCategory(cat);
		subcategorydao.save(subCat);
		System.out.print("in save");
		return getCategory(cat_id);

	
	}
	
	@GetMapping ("/orderView")
	public ModelAndView  orderView() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("orderView");
		List<Order> order=orderDao.findAll();
		mv.addObject("order",order);
		return mv;
	}
}
