package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orderr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime datetime = LocalDateTime.now();
	private Long total;
	private String receiver;
	private String receiverPhone;
	private String reciverAddress;
	private Long shoppingmoney;
	private Long offset;
	
	@ManyToOne
	private Member member;
	@OneToMany(mappedBy="order",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Cartitem> cartitems = new ArrayList<>();
	
	public void addCartitem(Cartitem cartitem) {
		cartitem.setOrder(this);
		cartitems.add(cartitem);
	}
	
	public Orderr() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReciverAddress() {
		return reciverAddress;
	}

	public void setReciverAddress(String reciverAddress) {
		this.reciverAddress = reciverAddress;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Long getShoppingmoney() {
		return shoppingmoney;
	}

	public void setShoppingmoney(Long shoppingmoney) {
		this.shoppingmoney = shoppingmoney;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public List<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	@Override
	public String toString() {
		return "Orderr [id=" + id + ", datetime=" + datetime + ", total=" + total + ", receiver=" + receiver
				+ ", receiverPhone=" + receiverPhone + ", reciverAddress=" + reciverAddress + ", member=" + member
				+ ", cartitems=" + cartitems + "]";
	}
	
}
