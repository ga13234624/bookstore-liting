package com.example.demo.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.example.demo.Member;

public class MemberForm {
	@NotBlank
	private String name;
	@Email
	private String email;
	private String checkedEmail;
	@Length(min=8,message="密碼至少需8位")
	private String password;
	private String checkedPassword;
	@NotBlank//須轉成LocalDate
	private String birthday;
	@Pattern(regexp="09[0-9]{8}",message="請輸入正確手機格式")
	private String mobile;
	private String location;
	
	public MemberForm() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCheckedEmail() {
		return checkedEmail;
	}

	public void setCheckedEmail(String checkedEmail) {
		this.checkedEmail = checkedEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckedPassword() {
		return checkedPassword;
	}

	public void setCheckedPassword(String checkedPassword) {
		this.checkedPassword = checkedPassword;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//確認信箱、密碼是否相同
	public boolean confirmEmail() {
		if(this.email.equals(this.checkedEmail)) {
			return true;
		}
		return false;
	}
	public boolean confirmPassword() {
		if(this.password.equals(this.checkedPassword)) {
			return true;
		}
		return false;
	}
	//轉換成Member的方法，供調用
	public Member convertToMember() {
		Member member = new MemberFormConvert().convert(this);
	    return member;
	}
	//內部類:轉換類:將值複製到Member(birthday轉成LocalDate)
	private class MemberFormConvert implements FormConvert<MemberForm,Member>{

		@Override
		public Member convert(MemberForm memberForm) {
			Member member = new Member();
			//將birthday轉換成LocalDate後設給member對象
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			member.setBirthday(LocalDate.parse(memberForm.getBirthday(),fmt));
			BeanUtils.copyProperties(memberForm, member);
			return member;
		}
		
	}
	
	
}
