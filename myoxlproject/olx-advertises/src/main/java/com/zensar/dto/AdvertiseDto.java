package com.zensar.dto;

import java.time.LocalDate;

public class AdvertiseDto {
	private int id;
	private String title;
	private double price;
	private String category;
	private String description;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private String advStatus;
	public AdvertiseDto() {}
	public AdvertiseDto(String title, double price, String category, String description, LocalDate createdDate,
			LocalDate modifiedDate, String status) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.advStatus = status;
	}
	public AdvertiseDto(int id, String title, double price, String category, String description, LocalDate createdDate,
			LocalDate modifiedDate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.advStatus = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getAdvStatus() {
		return advStatus;
	}
	public void setAdvStatus(String status) {
		this.advStatus = status;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AdvertiseDto [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", advStatus=" + advStatus + "]";
	}
}

/*
 
 {"id": 1, "title": "laptop sale", "price": 54000, "category": 
 "Electronic goods", "description": "intel core 3 Sony Vaio", "createdDate": xxx, "modifiedDate": xxx, "status": "OPEN"}
*/