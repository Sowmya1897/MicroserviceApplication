package com.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Products_tbl")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private int pid;
	@NotNull(message = "Product name is mandatory.")
	@Column(name="productName")
	private String productName;
	@NotNull(message = "Product category is mandatory.")
	@Column(name="category")
	private String category;
	@NotNull(message = "Product description is mandatory.")
	@Column(name="description")
	private String description;
	@NotNull(message = "Product price is mandatory.")
	@Column(name="price")
	private float price;

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product() {
		super();
		
	}
	public Product(int pid, String productName, String category, String description, float price) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", category=" + category + ", description="
				+ description + ", price=" + price + "]";
	}
}
