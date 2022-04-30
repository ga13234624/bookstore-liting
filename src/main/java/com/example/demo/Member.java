package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String password;
	private String name;
	private LocalDate birthday;
	private String email;
	private String mobile;
	private String location;
	private Long shoppingMoney = 0L;
	
	@OneToMany(mappedBy="member",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Orderr> orders;
//	@OneToOne(mappedBy="member",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
//	private Cart cart;
	@OneToMany(mappedBy="member",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Reorder> reorders;
	@OneToMany(mappedBy="member",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Cartitem> cartitems;
	
	public Member() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getShoppingMoney() {
		return shoppingMoney;
	}

	public void setShoppingMoney(Long shoppingMoney) {
		this.shoppingMoney = shoppingMoney;
	}

	public List<Orderr> getOrders() {
		return orders;
	}

	public void setOrders(List<Orderr> orders) {
		this.orders = orders;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	public List<Reorder> getReorders() {
		return reorders;
	}

	public void setReorders(List<Reorder> reorders) {
		this.reorders = reorders;
	}
	
	public List<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	
	
}
