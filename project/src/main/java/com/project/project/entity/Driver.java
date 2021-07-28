package com.project.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="driver")
public class Driver {

	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name ;
	
	private Integer mobile ;
	
	private boolean status;
	
	public Driver () {
		
	}

	public Driver(Integer id, String name, Integer mobile, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", mobile=" + mobile + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
