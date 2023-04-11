package com.soccer1.item.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Movice")
public class Movice extends Item{

	private String director;
	private String actor;
}
