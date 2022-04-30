package com.example.demo.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.example.demo.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
//	@Query("select b from book b where b.type=?1")
//	@QueryHints(value = { @QueryHint(value = "a query for pageable", name = "HINT_COMMENT")})
	@Query(value="select * from book where type= (:type)",nativeQuery=true)
	Page<Book> findByType(@Param("type") String type,Pageable pageable);

	//選出熱銷top10
	@Query(value="select * from book order by sales desc limit 5",nativeQuery=true)
	List<Book> findTop10();
	
	//選出新書
	@Query(value="select * from book order by publishdate desc limit 5",nativeQuery=true)
	List<Book> findNewbooks();
}
