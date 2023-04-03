package com.soccer1.order.entity;

import lombok.Getter;

@Getter
public enum OrderStatus {

	ORDER(1, "ORDER", "주문")
	, USER_CANCEL(2, "USER_CANCEL", "취소")
	, ADMIN_CANCEL(3, "ADMIN_CANCEL", "취소")
	, ETC_CANCEL(4, "ETC_CANCEL", "취소");
	
	private int code;
	private String type;
	private String desc;
	
	OrderStatus(int code, String type, String desc){
		this.code = code;
		this.type = type;
		this.desc = desc;
	}
	
}