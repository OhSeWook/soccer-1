package com.soccer1.order.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_order")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
}
