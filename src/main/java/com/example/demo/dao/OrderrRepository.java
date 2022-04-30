package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Orderr;

public interface OrderrRepository extends JpaRepository<Orderr, Long>{
	@Query(value="select * from orderr where member_id=?1",nativeQuery=true)
	List<Orderr> findByMemberId(Long memberid);
	@Query(value="select * from orderr where member_id= (:memberid)",nativeQuery=true)
	Page<Orderr> findByMemberId(@Param("memberid") Long memberid,Pageable pageable);
	@Query(value="select * from orderr where member_id= (:memberid) "
			+ "and datetime > date_sub(now(),interval (:period) month)",nativeQuery=true)
	Page<Orderr> findByMemberIdAndDatetime(@Param("memberid") Long memberid,
										   @Param("period") int period,
										   Pageable pageable);
}
