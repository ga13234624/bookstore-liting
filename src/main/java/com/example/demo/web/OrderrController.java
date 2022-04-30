package com.example.demo.web;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Book;
import com.example.demo.Cartitem;
import com.example.demo.Member;
import com.example.demo.Orderr;
import com.example.demo.form.ReceiverForm;
import com.example.demo.service.CartitemService;
import com.example.demo.service.MemberService;
import com.example.demo.service.OrderrService;

@Controller
@RequestMapping("/order")
public class OrderrController {
	@Autowired
	private OrderrService orderService;
	@Autowired
	private CartitemService cartitemService;
	@Autowired
	private MemberService memberService;
	
//	前往orderinfo Page
	@GetMapping("/addorderinfo")
	public String addOrder(HttpSession session,Model model,
			               final RedirectAttributes attribute) {
		Member member = (Member) session.getAttribute("member");
		//檢查數量
		String message = checkAmount(cartitemService.findCart(member.getId()));
		if(message!=null) {
			attribute.addFlashAttribute("message", message);
			return "redirect:/getcart";
		}
		model.addAttribute("receiverForm", new ReceiverForm());
		return "orderinfo";
		
	}
	
//	前往訂單confirm Page
	@PostMapping("/confirm")
	public String confirmOrder(@Valid ReceiverForm receiverForm,
							   BindingResult result,
							   HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("member");
		if(!receiverForm.checkOffset(member.getShoppingMoney())) {
			result.rejectValue("offset", "checkError","您的My幣不夠!" );
		}
		if(result.hasErrors()) return "orderinfo";
		
		List<Cartitem> cartitems = cartitemService.findCart(member.getId());
		Long cartsum = calculateTotal(cartitems,receiverForm.getOffset());
		session.setAttribute("shoppingmoney", cartsum/100);
		cartsum=(cartsum>=1000?cartsum:cartsum+60);
		session.setAttribute("cartitems", cartitems);
		session.setAttribute("cartsum", cartsum);
		session.setAttribute("receiverinfo", receiverForm.convertToReceiverinfo());
		return "orderconfirm";
	}
//	送出訂單
	@GetMapping("/sendorder")
	public String sendOrder(HttpSession session,
							Model model,final RedirectAttributes attribute) {
		//調出session中資料
		Member member = (Member) session.getAttribute("member");
		List<Cartitem> cartitems = cartitemService.findCart(member.getId());
		//檢查庫存量
		String message = checkAmount(cartitems);
		if(message!=null) {
			attribute.addFlashAttribute("message", message);
			return "redirect:/getcart";
		}
		//建立一個新的order
		Orderr order = new Orderr();
		for(Cartitem cartitem:cartitems) {
			order.addCartitem(cartitem);//建立cartitem與order關係
			cartitem.setMember(null);//移除cartitem與member關係
			changeBookInfo(cartitem.getBook(),cartitem.getQuantity());
		}
		orderService.saveOrder(sendOrder(session,order));
		memberService.saveMember(member);
		attribute.addFlashAttribute("message", "下訂成功");
		return "redirect:/homepage";
	}
	
///////////////////////////////////////////////////////////
	//確認購物車數量
	private String checkAmount(List<Cartitem> cartitems) {
		for(Cartitem cartitem:cartitems) {
			Book book = cartitem.getBook();
			if(cartitem.getQuantity()<0)
				return "『"+book.getName()+"』"
								 +"下訂數量需大於0";
			if(cartitem.getQuantity()>book.getAmount()) 
						return "『"+book.getName()+"』"
								 +"庫存量不足";
				}
		return null;
	}
	//計算購物車總額(未含運費)
	private Long calculateTotal(List<Cartitem> cartitems,Long offset) {
		Long cartsum = 0L;
		for(Cartitem cartitem:cartitems) 
			cartsum+=cartitem.getSubtotal();
		cartsum-=offset;
		return cartsum;
				
	}
	//改變書本銷售量及庫存
	private void changeBookInfo(Book book,Long quantity) {
		book.setSales(book.getSales()+quantity);
		book.setAmount(book.getAmount()-quantity);
	}
	//送出訂單
	private Orderr sendOrder(HttpSession session , Orderr order) {
		List<Object> receiverinfo = (List<Object>) session.getAttribute("receiverinfo");
		Long cartsum = (Long) session.getAttribute("cartsum");
		Long shoppingMoney = (Long) session.getAttribute("shoppingmoney");		
		Member member = (Member) session.getAttribute("member");
		
		
		Long newShoppingMoney = member.getShoppingMoney()-(Long) receiverinfo.get(3)+shoppingMoney;
		member.setShoppingMoney(newShoppingMoney);
		
		order.setShoppingmoney(shoppingMoney);
		order.setMember(member);
		order.setReceiver((String) receiverinfo.get(0));
		order.setReceiverPhone((String) receiverinfo.get(1));
		order.setReciverAddress((String) receiverinfo.get(2));
		order.setTotal(cartsum);
		order.setOffset((Long) receiverinfo.get(3));
		
		return order;
	}
}
