package com.soccer1.orderItem.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_order_item")
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;
	
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "order_id")
	private Long orderId;
	
	private int orderPrice;
	
	private int orderCnt;
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
}
