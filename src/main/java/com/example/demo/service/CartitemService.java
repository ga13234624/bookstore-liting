package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Cartitem;
import com.example.demo.Orderr;
import com.example.demo.dao.CartitemRepository;

@Service
public class CartitemService {
	@Autowired
	private CartitemRepository cartitemRepository;
	
//	增
	public Cartitem saveCartitem(Cartitem cartitem) {
		return cartitemRepository.save(cartitem);
	}
//	查所有cartitem
	public List<Cartitem> findCartitems(Long memberid){
		return cartitemRepository.findCartitems(memberid);
	}
//	查特定cartitem
	public Cartitem findCartitem(Long cartitemid) {
		return cartitemRepository.findById(cartitemid).get();
	}
	//購物車(不含下次再買)
	public List<Cartitem> findCart(Long memberid){
		return cartitemRepository.findCart(memberid);
	}
	//下次再買
	public List<Cartitem> findNextbuy(Long memberid){
		return cartitemRepository.findNextbuy(memberid);
	}
//	刪
	public void deleteCartitem(Long cartitem) {
		cartitemRepository.deleteById(cartitem);
	}
}
