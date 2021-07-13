package com.project.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table (name="cart")
public class Cart {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id ;
	@Column (name="sub_total")
	private int subTotal;
	@Column (name="shipping_amount")
	private int shipingAmount ;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name ="user_id")
	private User cartUser;
	
	public Cart() {
		
	}
	@OneToMany(mappedBy="lineCart")
	private List<LineItem> lineItem;

	@Override
	public String toString() {
		return "Cart [id=" + id + ", subTotal=" + subTotal + ", shipingAmount=" + shipingAmount + ", cartUser="
				+ cartUser + ", lineItem=" + lineItem + "]";
	}

	

	public Cart(int subTotal, int shipingAmount) {
		super();
		this.subTotal = subTotal;
		this.shipingAmount = shipingAmount;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getShipingAmount() {
		return shipingAmount;
	}

	public void setShipingAmount(int shipingAmount) {
		this.shipingAmount = shipingAmount;
	}

	public User getCartUser() {
		return cartUser;
	}

	public void setCartUser(User cartUser) {
		this.cartUser = cartUser;
	}

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}
	
	
}
