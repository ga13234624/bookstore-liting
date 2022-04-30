package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Member;
import com.example.demo.Orderr;
import com.example.demo.service.OrderrService;

@RestController
public class App {
	@Autowired
	private OrderrService orderService;
//	歷史訂單查詢
	@GetMapping("/myaccount/getorder")
	public String toOrderHistory(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		List<Orderr> orderlist = orderService.findByMemberId(member.getId());
		for(Orderr order:orderlist) {
			System.out.println("//////////////"+order);
		}
		member.setOrders(orderlist);
		return "orderhistory";
	}
}
