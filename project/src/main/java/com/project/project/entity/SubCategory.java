package com.project.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name ="sub_category")
public class SubCategory {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	@Column (name ="name")
	private String name ;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="category_id") 
	private Category category;

	public SubCategory() {
		
	}
	
	@OneToMany(mappedBy="subCategory",cascade= {CascadeType.ALL})
	private List <Product> product;

	public SubCategory(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [id=" + id + ", name=" + name + ", product=" + product + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	

	
	
}
