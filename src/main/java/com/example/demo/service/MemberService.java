package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Member;
import com.example.demo.dao.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
//	增
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
//	查
	public Member findByEmailAndPassword(String email,String password) {
		return memberRepository.findByEmailAndPassword(email, password);
	}
	public Member findByEmail(String email) {		
		return memberRepository.findByEmail(email);
	}
	public boolean findByEmailAndBirthday(String email,String birthday) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthday1 = LocalDate.parse(birthday,fmt);
		if(memberRepository.findByEmailAndBirthday(email,birthday1)!=null) {
			return true;
		}
		return false;
	}
}
