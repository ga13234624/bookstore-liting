package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
//  查
	//全站分類書單
	@GetMapping("/booklist/{menu}")
	public String getBookList(@RequestParam(defaultValue="5") int size,
			                  @RequestParam(defaultValue="0") int page,
			                  @RequestParam(defaultValue="1")int sortby,
							  @PathVariable(value="menu") String menu,
			                  Model model) {	
		String type = getType(menu);
		Pageable pageable = PageRequest.of(page,size,getSort(sortby));
		Page<Book> page1 = bookService.findByPage(type, pageable);
		model.addAttribute("type", type);
		model.addAttribute("page1", page1);
		model.addAttribute("menu", menu);
		model.addAttribute("sortby", sortby);
		return "findbooklist";
	}
	@GetMapping("/book/{id}")
	public String getBookDetail(@PathVariable Long id,Model model) {
		Book book;
		try {
			book=bookService.findById(id);
		}catch(java.util.NoSuchElementException e) {
			throw new BookNotFoundException("此書不存在");
		}
		
		model.addAttribute("book", book);
		return "book";
	}
	
	
/////////////////////////////////////////////////////////
	private Sort getSort(int sortby) {
		Sort sort = null;
		switch(sortby) {
		  case 1:
			  sort = Sort.by(Sort.Direction.DESC, "publishdate");
			  break;
		  case 2:
			  sort = Sort.by(Sort.Direction.ASC, "publishdate");
			  break;
		  case 3:
			  sort = Sort.by(Sort.Direction.DESC, "price");
			  break;
		  case 4:
			  sort = Sort.by(Sort.Direction.ASC, "price");
			  break;
		  case 5:
			  sort = Sort.by(Sort.Direction.DESC, "sales");
			  break;
		
		}
		return sort;
	}
	
	private String getType(String menu){
		switch(menu) {
		 case "1":
			 return "商業理財";
		 case "2":
			 return "考試用書";
		 case "3":
			 return "藝術設計";
		 case "4":
			 return "心理勵志";
		 case "5":
			 return "文學小說";
		 case "6":
			 return "親子教養";
		 case "7":
			 return "醫療保健";
		 case "8":
			 return "旅遊飲食";	 
		}
		return null;
	}
}
