package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cartitem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long quantity=1L;
	private Long price;//price*discount
	private Long subtotal;//price*quantity

	private Boolean nextbuy=false;
	
	@OneToOne
	private Book book;
//	@ManyToOne
//	private Cart cart;
	@ManyToOne
	private Orderr order;
	@ManyToOne
	private Member member;
	
	public Cartitem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
		setSubtotal();
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice() {
		this.price = Math.round(book.getPrice()*book.getDiscount());
	}
	
	public Boolean getNextbuy() {
		return nextbuy;
	}

	public void setNextbuy(Boolean nextbuy) {
		this.nextbuy = nextbuy;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
		setPrice();
		setSubtotal();
	}

	public Orderr getOrder() {
		return order;
	}

	public void setOrder(Orderr order) {
		this.order = order;
	}
	public Long getSubtotal() {
		return subtotal;
	}

	public void setSubtotal() {
		this.subtotal = price*quantity;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
