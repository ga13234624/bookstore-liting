package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Reorder;

public interface ReorderRepository extends JpaRepository<Reorder, Long>{
	List<Reorder> findByMemberId(Long memberid);
}
