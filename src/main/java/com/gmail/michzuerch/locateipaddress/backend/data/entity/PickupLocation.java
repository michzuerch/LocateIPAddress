package com.gmail.michzuerch.locateipaddress.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class PickupLocation extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Size(max = 255)
	@NotBlank
	@Column(unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
