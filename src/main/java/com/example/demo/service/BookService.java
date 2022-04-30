package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Book;
import com.example.demo.dao.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
//	查
	public Page<Book> findByPage(String type,Pageable pageable){
		return bookRepository.findByType(type,pageable);
	}
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}
	//熱銷top
	public List<Book> findTop10(){
		return bookRepository.findTop10();
	}
	//新書
	public List<Book> findNewbooks(){
		return bookRepository.findNewbooks();
	}
	
//	增
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
}
