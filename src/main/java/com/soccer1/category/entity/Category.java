package com.soccer1.category.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.soccer1.common.entity.BaseEntity;
import com.soccer1.item.entity.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_category")
public class Category extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parent;
	
	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();
	
	@ManyToMany
	@JoinTable(name = "tb_category_itme", joinColumns = @JoinColumn(name="category_id"), inverseJoinColumns = @JoinColumn(name="itme_id"))
	private List<Item> items = new ArrayList<Item>();
	
	public void addChild(Category category) {
		child.add(category);
		category.setParent(this);
	}
	
	public void addItems(Item item) {
		items.add(item);
	}
}
