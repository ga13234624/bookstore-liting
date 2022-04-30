package com.example.demo.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Cartitem;
import com.example.demo.Member;
import com.example.demo.Orderr;
import com.example.demo.Reorder;
import com.example.demo.dao.MemberRepository;
import com.example.demo.form.MemberForm;
import com.example.demo.form.ModifyForm;
import com.example.demo.service.CartitemService;
import com.example.demo.service.MemberService;
import com.example.demo.service.OrderrService;
import com.example.demo.service.ReorderService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderrService orderService;
	@Autowired 
	private ReorderService reorderService; 
	@Autowired
	private CartitemService cartitemService;
	
//	登入
	@GetMapping("/login")
	public String toLoginPage(HttpServletRequest request,Model model) {
		//取得將跳轉的頁面
		String targetUrl = findPreUrl(request);
		if(targetUrl!=null) {
			model.addAttribute("targetUrl", targetUrl);
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="email") String email,
						@RequestParam(value="password") String password,
						@RequestParam(value="targetUrl",defaultValue="homepage") String targetUrl,
						HttpSession session,Model model,
						final RedirectAttributes attribute) {		
		Member member = memberService.findByEmailAndPassword(email, password);
		if(member!=null) {
			attribute.addFlashAttribute("message", "登入成功!歡迎光臨!");
			session.setAttribute("member", member);
			return "redirect:/"+targetUrl;
		}else {
			model.addAttribute("message", "帳號或密碼有誤，請重新登入");
			return "login";
		}		
	}
	
//	加入會員
	@GetMapping("/join")
	public String toJoinPage(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "joinpage";
	}
	
	@PostMapping("/join")
	public String join(@Valid MemberForm memberForm,
				   	   BindingResult result,HttpSession session) {
		
		//確認信箱一致及重複註冊
		if(!memberForm.confirmEmail()) {
			result.rejectValue("checkedEmail", "confirmError","兩次信箱不一致" );
		}
		if(memberService.findByEmail(memberForm.getEmail())!=null) {
			result.rejectValue("email", "confirmError","此信箱已註冊過" );
		}
		//確認密碼一致
		if(!memberForm.confirmPassword()) {
			result.rejectValue("checkedPassword", "confirmError", "兩次密碼不一致");
		}
		if(!checkPwdFormat(memberForm.getEmail(),memberForm.getPassword())) {
			result.rejectValue("password", "confirmError", "密碼不可與信箱相同");
		}
		//有錯誤返回joinpage
		if(result.hasErrors()) {
			return "joinpage";
		}
		Member member = memberForm.convertToMember();
		memberService.saveMember(member);
		return "redirect:/member/login";
	}
	
//	登出
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		return "redirect:/homepage";
	}
	
//	會員專區
	@GetMapping("/myaccount/index")
	public String toIndex() {
		return "indexpage";
	}

//	會員資料修改
	@GetMapping("/myaccount/modifyMemberinfo")
	public String toModifyMemberinfoPage(Model model) {
		model.addAttribute("modifyForm", new ModifyForm());
		return "modifymemberinfo";
	}
	@PostMapping("/myaccount/modifyMemberinfo")
	public String modifyMemberinfo(@Valid ModifyForm modifyForm,
								   BindingResult result,
								   HttpSession session,Model model) {
		//確認基本格式
		if(result.hasErrors()) {
			return "modifymemberinfo";
		}
		//確認密碼是否正確
		Member member = (Member) session.getAttribute("member");	
		if(modifyForm.getPassword().equals(member.getPassword())) {
			member.setName(modifyForm.getName());
			member.setMobile(modifyForm.getMobile());
			member.setLocation(modifyForm.getLocation());
			memberService.saveMember(member);
			model.addAttribute("message", "修改成功!");
			return "modifymemberinfo";
		}else {
			model.addAttribute("message", "密碼輸入錯誤，請重新填寫!");
			return "modifymemberinfo";
		}
	}
	
//	修改密碼
	@GetMapping("/myaccount/changePassword")
	public String toChangePasswordPage() {
		return "changepassword";
	}
	@PostMapping("/myaccount/changePassword")
	public String changePassword(@RequestParam(value="expassword") String expassword,
								 @RequestParam(value="newpassword") String newpassword,
								 HttpSession session,Model model,
								 final RedirectAttributes attribute ) {
		Member member = (Member) session.getAttribute("member");
		if(newpassword==null || newpassword.length()<8) {
			model.addAttribute("message", "請輸入正確密碼格式(至少8位數)!");
			return "changepassword";
		}
		if(expassword.equals(member.getPassword())) {
			member.setPassword(newpassword);
			memberService.saveMember(member);
			attribute.addFlashAttribute("message", "您已被登出，請以新密碼登入!");
			return "redirect:/member/logout";
		}else {
			model.addAttribute("message", "舊密碼輸入錯誤，請重新填寫!");
			return "changepassword";
		}
	}
	
//	歷史訂單查詢
	@GetMapping("/myaccount/getorder")
	public String toOrderHistory(@RequestParam(defaultValue="10") int size,
			  					 @RequestParam(defaultValue="0") int page,
			  					 @RequestParam(defaultValue="0") int period,
								 HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("member");
		Sort sort = Sort.by(Sort.Direction.DESC, "datetime");
		Pageable pageable = PageRequest.of(page , size , sort);
		Page<Orderr> page1;
		if(period==0) {
			page1 = orderService.findByMemberId(member.getId(), pageable);
		}else{
			page1 = orderService.findByMemberIdAndDatetime(member.getId(),period,pageable);
		}
		model.addAttribute("page1", page1);
		model.addAttribute("period", period);
		return "orderhistory";
	}
	
//	可訂購通知
	@GetMapping("/myaccount/getreorder")
	public String toReorderList(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		List<Reorder> reorders = reorderService.findByMemberId(member.getId());
		member.setReorders(reorders);
		return "reorderlist";
	}
	
//	下次再買清單
	@GetMapping("/myaccount/nextbuy")
	public String toNextbuyList(HttpSession session,Model model) {
		Member member = (Member) session.getAttribute("member");
		model.addAttribute("nextbuy", cartitemService.findNextbuy(member.getId()));
		return "nextbuylist";
	}
	
//  忘記密碼
	@PostMapping("/forgot")
	public String forgot(@RequestParam String email,
			             @RequestParam String birthday,
			             final RedirectAttributes attribute,
			             Model model) {
		if(memberService.findByEmailAndBirthday(email,birthday)) {
			attribute.addFlashAttribute("message", "已發送新密碼至"+email);
			return "redirect:/homepage";
		}
		model.addAttribute("message", "信箱或生日有誤");
		return "forgot";
	}
//////////////////////////////////////////////////////////////	
    //測試500異常
	@GetMapping("/exception")
	public String testException() {
		throw new RuntimeException("測試異常處理");
	}
	//取得前頁面網址
	private String findPreUrl(HttpServletRequest request) {
		String referer = request.getHeader("referer");
		//本站網址開頭
		String basePath = request.getScheme()+"://"+
						  request.getServerName()+":"+
						  request.getServerPort()+request.getContextPath()+"/";
		//如非跳轉或非從其他站跳轉
		if(referer==null || !referer.startsWith(basePath)) return null;
		String preUrl = referer.replace(basePath, "");
		return preUrl;

	}
	//密碼格式驗證
	private boolean checkPwdFormat(String email,String pwd) {
		String emailPrefix = getEmailPrefix(email);
		if(!emailPrefix.equals(pwd)) return true;
		return false;
	}
	private String getEmailPrefix(String email) {
		int index = email.indexOf('@');
		StringBuffer sbf = new StringBuffer(email);
		return new String(sbf.delete(index, sbf.length()));
		
	}
}
