package com.project.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="orders")
public class Order {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int subTotal;
	
	@Column (name="shipping_amount")
	private int shippingAmount ;
	
	private String status;
	
	@ManyToOne (cascade= {CascadeType.MERGE, CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn (name="user_id")
	private User user_order ;

	@OneToOne
	@JoinColumn(name ="driver")
	private Driver orderDriver;
	
	@OneToOne
	@JoinColumn (name ="picker")
	private Picker orderPicker;
	
	public Order() {
		
	}

	public Order(int subTotal, int shippingAmount, String status) {
		this.subTotal = subTotal;
		this.shippingAmount = shippingAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", subTotal=" + subTotal + ", shippingAmount=" + shippingAmount + ", status="
				+ status + ", user_order=" + user_order + ", orderDriver=" + orderDriver + ", orderPicker="
				+ orderPicker + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(int shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser_order() {
		return user_order;
	}

	public void setUser_order(User user_order) {
		this.user_order = user_order;
	}

	public Driver getOrderDriver() {
		return orderDriver;
	}

	public void setOrderDriver(Driver orderDriver) {
		this.orderDriver = orderDriver;
	}

	public Picker getOrderPicker() {
		return orderPicker;
	}

	public void setOrderPicker(Picker orderPicker) {
		this.orderPicker = orderPicker;
	}
	
	
	
}
