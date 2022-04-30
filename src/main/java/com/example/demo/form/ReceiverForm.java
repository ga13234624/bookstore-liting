package com.example.demo.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.experimental.FieldDefaults;

public class ReceiverForm {
	@NotBlank
	private String receivername;
	@Pattern(regexp="09\\d{8}",message="請輸入正確手機格式")
	private String receiverphone;
	private String receiveraddress;
	@NotNull
	private Long offset;
	
	public ReceiverForm() {
		super();
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceiverphone() {
		return receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}
    //確認My幣數量
	public boolean checkOffset(Long shoppingmoney) {
		if(shoppingmoney<offset) 
			return false;
		return true;
	}
	//轉成receiverinfo
	public List<Object> convertToReceiverinfo(){
		List<Object> receiverinfo = new ArrayList<>();
		receiverinfo.add(receivername);
		receiverinfo.add(receiverphone);
		receiverinfo.add(receiveraddress);
		receiverinfo.add(offset);
		return receiverinfo;
	}
}
