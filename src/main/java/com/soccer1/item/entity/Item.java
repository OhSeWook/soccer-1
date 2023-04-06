package com.soccer1.item.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.soccer1.category.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
@Table(name = "tb_item")
public abstract class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;
	
	private String name;
	
	private int price;
	
	private String stockQuantity;//재고수량
	
	@ManyToMany(mappedBy = "items")
	private List<Category> categorys = new ArrayList<Category>();
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
}
