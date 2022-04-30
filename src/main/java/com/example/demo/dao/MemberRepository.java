package com.example.demo.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmailAndPassword(String email,String password);
	Member findByEmail(String email);
	Member findByEmailAndBirthday(String email,LocalDate birthday);
	
}
