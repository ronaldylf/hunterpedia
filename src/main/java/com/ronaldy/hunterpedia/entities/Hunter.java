package com.ronaldy.hunterpedia.entities;

import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_hunters")
public class Hunter {
	@Id
	@Column(name = "ID", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
    private UUID id;

	private String name;
	private String gender;
	private Double heigth;
	private Integer age;
	private String nenType;
	private Integer nenAmount;
	private String image;

	public Hunter() {
		super();
	}
	
	public Hunter(UUID id, String name, String gender, Double heigth, Integer age, String nenType, Integer nenAmount,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.heigth = heigth;
		this.age = age;
		this.nenType = nenType;
		this.nenAmount = nenAmount;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getHeigth() {
		return heigth;
	}

	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNenType() {
		return nenType;
	}

	public void setNenType(String nenType) {
		this.nenType = nenType;
	}

	public Integer getNenAmount() {
		return nenAmount;
	}

	public void setNenAmount(Integer nenAmount) {
		this.nenAmount = nenAmount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	
}
