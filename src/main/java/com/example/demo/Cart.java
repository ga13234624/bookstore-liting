//package com.example.demo;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Cart {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@OneToOne
//	private Member member;
//	private Long total;
//	@OneToMany(mappedBy="cart",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
//	private List<Cartitem> cartitems;
//	
//	public Cart() {
//		super();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}
//
//	public List<Cartitem> getCartitems() {
//		return cartitems;
//	}
//
//	public void setCartitems(List<Cartitem> cartitems) {
//		this.cartitems = cartitems;
//	}
//
//	public Long getTotal() {
//		return total;
//	}
//
//	public void setTotal(Long total) {
//		this.total = total;
//	} 
//	
//}
