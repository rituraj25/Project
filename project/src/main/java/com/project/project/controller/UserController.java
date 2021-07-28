package com.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.project.Dao.CartDao;
import com.project.project.Dao.CategoryDao;
import com.project.project.Dao.LineReposetory;
import com.project.project.Dao.OrderDao;
import com.project.project.Dao.OrderItemDao;
import com.project.project.Dao.ProductDao;
import com.project.project.Dao.Userdao;
import com.project.project.entity.Cart;
import com.project.project.entity.LineItem;
import com.project.project.entity.Order;
import com.project.project.entity.OrderItem;
import com.project.project.entity.Product;
import com.project.project.entity.User;

@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired 
	private CategoryDao categorydao;
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired 
	private LineReposetory linerepo;
	
	@Autowired 
	private Userdao userdao;
	@Autowired 
	private CartDao cartDao;
	
	@Autowired 
	private OrderDao orderDao;
	
	@Autowired 
	private OrderItemDao orderItemDao;
	
	@GetMapping("/products")
	public ModelAndView showProducts() {
		ModelAndView mv=new ModelAndView();
		List<Product>product= productdao.findAll();
		mv.addObject("product",product);
		mv.setViewName("products");
		return mv;
	}
	public Cart   setCart() {
		Cart lineCart =new Cart();
		lineCart =cartDao.getById(1);
		User cartUser= userdao.getById(2);
		lineCart.setCartUser(cartUser);
		return lineCart;
	}
	@GetMapping ("/addToCart/{id}")
			public ModelAndView addToCart (@PathVariable int id) {
		Product pr=productdao.getById(id);
		LineItem line= new LineItem();
		
		line.setQuantity(1);
		line.setShippingAmount(pr.getPrice());
		line.setSubTotal(pr.getPrice());
		line.setPrice(pr.getPrice());
		line.setLineProduct(pr);
		line.setLineCart(setCart());
		linerepo.save(line);
		ModelAndView mv=new ModelAndView();
		List<Product>product= productdao.findAll();
		mv.addObject("product",product);
		mv.setViewName("products");
		return mv;
	}
	
	@GetMapping ("/cart")
	public ModelAndView showCart() {
		Cart cart=cartDao.getById(1);
		ModelAndView mv=new ModelAndView ();
		mv.addObject("cart",cart);
		mv.setViewName("cartList");
		return mv;
	}
	
	@GetMapping ("/order")
	public ModelAndView order() {
		Cart cart=cartDao.getById(1);
		
		Order order =new Order();
		order.setUser_order(cart.getCartUser());
		order.setStatus("Order Placed");
		for (int i=0;i<cart.getLineItem().size();i++) {
			if (!cart.getLineItem().get(i).isStatus()) {
				cart.getLineItem().get(i).setStatus(true);
				{
					OrderItem orderItem= new OrderItem();
				orderItem.setOrder_item(order);
				orderItem.setPrice(cart.getLineItem().get(i).getPrice());
				orderItem.setQuantity(cart.getLineItem().get(i).getQuantity());
				orderItem.setShippingAmount(cart.getLineItem().get(i).getShippingAmount());
				orderItem.setSub_total(cart.getLineItem().get(i).getSubTotal());
				orderItem.setStatus("Order Placed");
				orderItem.setProduct_item(cart.getLineItem().get(i).getLineProduct());
				System.out.println(orderItem);

				orderItemDao.save(orderItem);
				}
				cartDao.save(cart);
			}
			
		}
		ModelAndView mv=new ModelAndView ();
		mv.setViewName("order");
		return mv;
	}
	
	
}
