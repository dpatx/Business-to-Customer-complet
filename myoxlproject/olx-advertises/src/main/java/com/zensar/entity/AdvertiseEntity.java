package com.zensar.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "ADVERTISES")
@Entity
public class AdvertiseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private double price;
	@Column
	private String category;
	@Column
	private String description;
	@Column
	private LocalDate createdDate;
	@Column
	private LocalDate modifiedDate;
	@Column
	private String status;
	public AdvertiseEntity() {}
	public AdvertiseEntity(String title, double price, String category, String description, LocalDate createdDate,
			LocalDate modifiedDate, String status) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	public AdvertiseEntity(int id, String title, double price, String category, String description, LocalDate createdDate,
			LocalDate modifiedDate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", status=" + status + "]";
	}

}
