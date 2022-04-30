package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Cartitem;

public interface CartitemRepository extends JpaRepository<Cartitem, Long>{
	
	@Query(value="select * from cartitem where member_id=?1",nativeQuery=true)
	List<Cartitem> findCartitems(Long memberid);
	@Query(value="select * from cartitem where member_id=?1 and nextbuy=false",nativeQuery=true)
	List<Cartitem> findCart(Long memberid);
	@Query(value="select * from cartitem where member_id=?1 and nextbuy=true",nativeQuery=true)
	List<Cartitem> findNextbuy(Long memberid);
	
}
