package com.example.demo.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class ModifyForm {
	@NotBlank
	private String name;
	
	@Pattern(regexp="09[0-9]{8}",message="請輸入正確手機格式")
	private String mobile;
	
	private String location;
	
	@Length(min=8,message="密碼至少需8位")
	private String password;

	public ModifyForm() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
