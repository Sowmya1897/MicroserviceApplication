package com.order.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Order_tbl")
public class Order {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oid")	
private int oid;
@Size(min = 4, max = 16)
@NotNull(message = "customer name is mandatory.")
@Column(name="cust_name")
private String cust_name;
@NotNull(message = "customer address is mandatory.")
@Column(name="cust_address")
private String cust_address;
@Column(name="order_status")
private String order_status;
@Column(name="order_datetime")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
private LocalDateTime order_datetime;

@Column(name="p_id")
private int pid;

@Column(name="quantity", nullable=false)
private int quantity;

public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public String getCust_address() {
	return cust_address;
}
public void setCust_address(String cust_address) {
	this.cust_address = cust_address;
}
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public LocalDateTime getOrder_datetime() {
	return order_datetime;
}
public void setOrder_datetime(LocalDateTime order_datetime) {
	this.order_datetime = order_datetime;
}


public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Order() {
	super();
	
}
public Order(int oid, @Size(min = 4, max = 16) @NotNull(message = "customer name is mandatory.") String cust_name,
		@NotNull(message = "customer address is mandatory.") String cust_address, String order_status,
		LocalDateTime order_datetime, int pid, int quantity) {
	super();
	this.oid = oid;
	this.cust_name = cust_name;
	this.cust_address = cust_address;
	this.order_status = order_status;
	this.order_datetime = order_datetime;
	this.pid = pid;
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Order [oid=" + oid + ", cust_name=" + cust_name + ", cust_address=" + cust_address + ", order_status="
			+ order_status + ", order_datetime=" + order_datetime + ", pid=" + pid + ", quantity=" + quantity + "]";
}


}
