package com.soccer1.item.entity;

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
@Table(name = "tb_item")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;
	
	private String name;
	
	private int price;
	
	private String stockQuantity;//재고수량
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
}
