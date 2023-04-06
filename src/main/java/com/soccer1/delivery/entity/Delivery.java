package com.soccer1.delivery.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.soccer1.order.entity.Order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_order")
public class Delivery {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private Long id;
	
	@OneToOne(mappedBy = "delivery")
	private Order order;
	
	private String city;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;
	
	private String zipcode;
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
	
}
