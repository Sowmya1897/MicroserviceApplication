package com.invoice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Invoice_tbl")
public class Invoice {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="invoice_id")
private int invoiceId;
@Column(name="oid")
private int oid;
@Column(name="totalAmount")
private float totalAmount;
@Column(name="paymentStatus")
private String paymentStatus;
public int getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(int invoiceId) {
	this.invoiceId = invoiceId;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public float getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(float totalAmount) {
	this.totalAmount = totalAmount;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public Invoice() {
	super();
	
}
public Invoice(int invoiceId, int oid, float totalAmount, String paymentStatus) {
	super();
	this.invoiceId = invoiceId;
	this.oid = oid;
	this.totalAmount = totalAmount;
	this.paymentStatus = paymentStatus;
}


}
