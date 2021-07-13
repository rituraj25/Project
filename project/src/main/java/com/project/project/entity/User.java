package com.project.project.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name ="user")
public class User {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="id")
	private int id ;
	@Column (name ="email")
	private String email;
	@Column (name ="password")
	private String password ;
	@Column (name="resetpassword_sent_at")
	private Date resetPasswordSentAt;
	@Column (name="signin_count")
	private int signinCount;
	@Column (name ="last_signin")
	private Date lastSignin;
	@Column (name="created_at")
	private Date createdAt;
	@Column (name="updated_at")
	private Date updatedAt;
	@Column (name="name")
	private String name ;
	@Column (name="admin")
	private boolean admin;
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List <Contact> contact ;

	@OneToOne(mappedBy="cartUser")
	private Cart cart;
	
	
	public User () {
		
	}
	


	public User(String email, String password, Date resetPasswordSentAt, int signinCount, Date lastSignin,
			Date createdAt, Date updatedAt, String name, boolean admin) {
		super();
		this.email = email;
		this.password = password;
		this.resetPasswordSentAt = resetPasswordSentAt;
		this.signinCount = signinCount;
		this.lastSignin = lastSignin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
		this.admin = admin;
	}



	


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", resetPasswordSentAt="
				+ resetPasswordSentAt + ", signinCount=" + signinCount + ", lastSignin=" + lastSignin + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", name=" + name + ", admin=" + admin + ", contact="
				+ contact + ", cart=" + cart + "]";
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getResetPasswordSentAt() {
		return resetPasswordSentAt;
	}


	public void setResetPasswordSentAt(Date resetPasswordSentAt) {
		this.resetPasswordSentAt = resetPasswordSentAt;
	}


	public int getSigninCount() {
		return signinCount;
	}


	public void setSigninCount(int signinCount) {
		this.signinCount = signinCount;
	}


	public Date getLastSignin() {
		return lastSignin;
	}


	public void setLastSignin(Date lastSignin) {
		this.lastSignin = lastSignin;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public List<Contact> getContact() {
		return contact;
	}


	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
