package com.soccer1.delivery.entity;

import lombok.Getter;

@Getter
public enum DeliveryStatus {

	READY(0, "READY", "배송 준비")
	, ING(1, "ING", "배송 중")
	, COMPLETE(2, "COM", "배송 완료")
	, CANCEL(3, "USER_CANCEL", "배송 취소")
	, ADMIN_CANCEL(4, "ADMIN_CANCEL", "배송 관리자 취소")
	, ERROR_CANCEL(5, "ERROR_CANCEL", "배송 에러 취소")
	, ETC_CANCEL(6, "ETC_CANCEL", "배송 기타 취소");
	
	private int code;
	private String type;
	private String desc;
	
	DeliveryStatus(int code, String type, String desc){
		this.code = code;
		this.type = type;
		this.desc = desc;
	}
	
}
