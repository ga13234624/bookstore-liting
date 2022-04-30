package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Book;
import com.example.demo.Member;
import com.example.demo.Reorder;
import com.example.demo.service.BookService;
import com.example.demo.service.ReorderService;

@Controller
@RequestMapping("/reorder")
public class ReorderController {
	@Autowired
	private BookService bookService;
	@Autowired
	private ReorderService reorderService;
//	增
	@PostMapping("/add")
	public String addToReorder(@RequestParam(value="bookid") Long bookid,
							   HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("member");
		Book book = bookService.findById(bookid);
		//找到屬於此member的reorders列表
		if(!checkReorder(member,bookid)) {
			Reorder reorder = new Reorder();
			reorder.setBook(book);
			reorder.setMember(member);
			reorderService.saveReorder(reorder);
			member.getReorders().add(reorder);
		}
		model.addAttribute("book", book);
		return "book";
	}
	
//	刪
	@PostMapping("/delete")
	public String deleteReorder(@RequestParam(value="reorderID")Long reorderid) {
		reorderService.deleteById(reorderid);
		return "redirect:/member/myaccount/getreorder";
	}
	
/////////////////////////////////////////////////////
	//可訂購通知我清單是否已有
	private boolean checkReorder(Member member, Long bookid) {
		List<Reorder> reorders = reorderService.findByMemberId(member.getId());
		for(Reorder reorder:reorders) {
			if(reorder.getBook().getId()==bookid) return true;
			}
		return false;
	}
//	//是否是自己的清單
//	private boolean checkMyReorder()
}
