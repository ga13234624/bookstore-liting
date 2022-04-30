package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Book;
import com.example.demo.Orderr;
import com.example.demo.dao.OrderrRepository;

@Service
public class OrderrService {
	@Autowired
	private OrderrRepository orderRepository;
//	查
	public List<Orderr> findByMemberId(Long memberid){
		return orderRepository.findByMemberId(memberid);
	}
	public Page<Orderr> findByMemberId(Long memberid,Pageable pageable){
		return orderRepository.findByMemberId(memberid,pageable);
	}
	public Page<Orderr> findByMemberIdAndDatetime(Long memberid, int period, Pageable pageable){
		return orderRepository.findByMemberIdAndDatetime(memberid, period, pageable);
	}
//	增
	public Orderr saveOrder(Orderr order) {
		return orderRepository.save(order);
	}
}
