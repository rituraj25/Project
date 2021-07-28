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
@Table (name="order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name="subTotal")
	private int sub_total;

	private int price;
	
	private int quantity ;
	@Column (name="shippingAmount")
	private int shippingAmount ;
	
	private String status;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn (name ="order_id")
	private Order order_item;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn (name="product_id")
	private Product product_item;
	
	public OrderItem() {
		
	}

	public OrderItem(int sub_total, int price, int quantity, int shippingAmount, String status) {
		super();
		this.sub_total = sub_total;
		this.price = price;
		this.quantity = quantity;
		this.shippingAmount = shippingAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", sub_total=" + sub_total + ", price=" + price + ", quantity=" + quantity
				+ ", shippingAmount=" + shippingAmount + ", status=" + status + ", order_item=" + order_item
				+ ", product_item=" + product_item + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSub_total() {
		return sub_total;
	}

	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order getOrder_item() {
		return order_item;
	}

	public void setOrder_item(Order order_item) {
		this.order_item = order_item;
	}

	public Product getProduct_item() {
		return product_item;
	}

	public void setProduct_item(Product product_item) {
		this.product_item = product_item;
	}
	
}
