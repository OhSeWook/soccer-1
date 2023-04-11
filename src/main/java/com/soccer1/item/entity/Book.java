package com.soccer1.item.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Book")
public class Book extends Item{

	private String author;
	private String isbn;
}
