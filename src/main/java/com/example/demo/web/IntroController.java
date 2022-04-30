package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Book;
import com.example.demo.service.BookService;

@Controller
public class IntroController {
	@Autowired
	private BookService bookService;
//  前往首頁
	@GetMapping("/homepage")
	public String toHomePage(Model model) {
		List<Book> newbooks = bookService.findNewbooks();
		List<Book> top10 = bookService.findTop10();
		model.addAttribute("top10", top10);
		model.addAttribute("newbooks", newbooks);
		return "homepage";
	}
//  前往關於My書
	@GetMapping("/about")
	public String toAbout() {
		return "about";
	}
	
//	前往隱私權與服務
	@GetMapping("/privacyAndService")
	public String toPrivacyAndService() {
		return "privacyAndService";
	}

//	前往新手上路
	@GetMapping("/guide")
	public String toGuide() {
		return "guide";
	}
	
//	前往Q&A
	@GetMapping("/Q&A")
	public String toQandA() {
		return "QandA";
	}
	
//	忘記密碼
	@GetMapping("/forgot")
	public String toForgot() {
		return "forgot";
	}
//	Facebook
	@GetMapping("/Facebook")
	public String toGuide(RedirectAttributes attribute) {
		attribute.addFlashAttribute("message", "目前粉專尚未建立，敬請期待");
		return "redirect:/homepage";
	}

}
