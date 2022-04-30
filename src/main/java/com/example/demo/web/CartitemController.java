package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Book;
import com.example.demo.Cartitem;
import com.example.demo.Member;
import com.example.demo.service.BookService;
import com.example.demo.service.CartitemService;
import com.example.demo.service.MemberService;

@Controller
public class CartitemController {
	@Autowired
	private BookService bookService;
	@Autowired
	private CartitemService cartitemService;
	
//  增
	//加到購物車
	@PostMapping("/addtocart")
	public String addToCart(@RequestParam(value="bookid") Long bookid,
							HttpSession session,
							final RedirectAttributes attribute) {
		Book book = bookService.findById(bookid);
		Member member = (Member) session.getAttribute("member");
		//獲取購物項
		Cartitem cartitem = checkCartitem(member,bookid);
		
        if(cartitem!=null) {
        	if(cartitem.getNextbuy()) {
        		cartitem.setNextbuy(false);
        		cartitemService.saveCartitem(cartitem);
        	}
        }else {
        	Cartitem newcartitem = new Cartitem();
    		newcartitem.setBook(book);
    		newcartitem.setMember(member);
    		cartitemService.saveCartitem(newcartitem);	
        }
        	
    		attribute.addAttribute("id", bookid);
    		return "redirect:/book/{id}";
        
	}
	//改數量
	@PostMapping("/changequantity")
	public String changeQuantity(@RequestParam(value="quantity",defaultValue="1") Long quantity,
								 @RequestParam(value="cartitemid") Long cartitemid,
								 final RedirectAttributes attribute){
		Cartitem cartitem = cartitemService.findCartitem(cartitemid); 
		String message = checkAmount(quantity,cartitem);
		if(message!=null) {
			attribute.addFlashAttribute("message", message);
			return "redirect:/getcart";
		}
		cartitem.setQuantity(quantity);
		cartitemService.saveCartitem(cartitem);
		return "redirect:/getcart";
	}
	
//	查
	//購物車列表
	@GetMapping("/getcart")
	public String findCart(HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("member");
		List<Cartitem> cartitems = cartitemService.findCart(member.getId());
		Long cartsum=0L;
		//計算cartitem總和
		for(Cartitem cartitem:cartitems) {
			cartsum+=cartitem.getSubtotal();
		}
		//將cartsum.cartitems返回前端
		model.addAttribute("cartsum", cartsum);
		model.addAttribute("cartitems", cartitems);
		return "cart";
	}
	
//	刪
	@GetMapping("/delete/cartitem/{cartitemid}")
	public String deleteCartitem(@PathVariable Long cartitemid,
			                     HttpSession session) {
		Cartitem cartitem = cartitemService.findCartitem(cartitemid);
		if(checkMyCartitem(cartitem,session)) 
			cartitemService.deleteCartitem(cartitemid);
		return "redirect:/getcart";
	}
	
//	加到下次再買清單、加回購物車
	@GetMapping("/changeNextbuy/{cartitemid}")
	public String nextBuy(@PathVariable Long cartitemid,
			              HttpSession session) {
		Cartitem cartitem = cartitemService.findCartitem(cartitemid);
		if(checkMyCartitem(cartitem,session)) {
			if(cartitem.getNextbuy()) {
				cartitem.setNextbuy(false);
				cartitemService.saveCartitem(cartitem);
				return "redirect:/member/myaccount/nextbuy";
			}else {
				cartitem.setNextbuy(true);
				cartitemService.saveCartitem(cartitem);
				return "redirect:/getcart";
			}
		}
		return "redirect:/getcart";
	}
	
////////////////////////////////////////////////////////
	//檢查member的cartitem是否已有
	private Cartitem checkCartitem(Member member,Long bookid) {
		//懶加載所以要find出來
		List<Cartitem> cartitems = cartitemService.findCartitems(member.getId());
		//比對member中cartitems是否有同品項，如有則不再重複添加
		for(Cartitem cartitem:cartitems) {
			if(cartitem.getBook().getId().equals(bookid)) return cartitem;
		}
		return null;
	}
	//檢查是否是自己的cartitem
	private boolean checkMyCartitem(Cartitem cartitem,HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(cartitem.getMember().getId().equals(member.getId())) 
			return true;
		return false;
	}
	//確認購物車數量
	private String checkAmount(Long quantity,Cartitem cartitem) {
		Book book = cartitem.getBook();
		if(quantity<=0)
			return "『"+book.getName()+"』"
							+"下訂數量需大於0";
		if(quantity>book.getAmount()) 
			return "『"+book.getName()+"』"
							+"庫存量不足";
		return null;
	}
}
