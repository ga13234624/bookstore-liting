package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Reorder;
import com.example.demo.dao.ReorderRepository;

@Service
public class ReorderService {
	@Autowired
	private ReorderRepository reorderRepository;
//  增
	public Reorder saveReorder(Reorder reorder) {
		return reorderRepository.save(reorder);
	}
//	查
	public List<Reorder> findByMemberId(Long memberid){
		return reorderRepository.findByMemberId(memberid);
	}
//  刪
	public void deleteById(Long reorderid) {
		reorderRepository.deleteById(reorderid);
	}
}
