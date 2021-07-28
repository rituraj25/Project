package com.project.project.entity;

import java.util.Date;

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
@Table (name ="line_item")
public class LineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	@Column (name="quantity")
	private int quantity;
	@Column (name="shiping_amount")
	private int shippingAmount;
	@Column(name="sub_total")
	private int subTotal;
	@Column (name="price")
	private int price ;
	@Column (name="created_at")
	private Date createdAt ;
	@Column (name ="updated_at")
	private Date updatedAt;
	
	private boolean status;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn (name="cart_id")
	private Cart lineCart;
	
	@OneToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name ="product_id")
	private Product lineProduct;

	public LineItem() {
		
	}

	public LineItem(int id, int quantity, int shippingAmount, int subTotal, int price, Date createdAt, Date updatedAt,
			boolean status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.shippingAmount = shippingAmount;
		this.subTotal = subTotal;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(int shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Cart getLineCart() {
		return lineCart;
	}

	public void setLineCart(Cart lineCart) {
		this.lineCart = lineCart;
	}

	public Product getLineProduct() {
		return lineProduct;
	}

	public void setLineProduct(Product lineProduct) {
		this.lineProduct = lineProduct;
	}

	
		
	
}
