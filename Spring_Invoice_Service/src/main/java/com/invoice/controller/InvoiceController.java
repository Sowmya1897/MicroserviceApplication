package com.invoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.model.Invoice;
import com.invoice.repository.InvoiceRepository;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	InvoiceRepository repository;
	
	
@PostMapping("/saveInvoices")
	public String addInvoice(@RequestBody Invoice invoice) {
	String message;
     int invoiceId = 0;
     invoiceId = repository.save(invoice).getInvoiceId();
	if(invoiceId>0) {
		
		message ="Invoice added successfully with id "+invoiceId+".";
	}else {
		message="Cannot generate invoice because your order is cancelled!";
	}
	return message;
		
	}

@GetMapping("/invoices")
@ResponseBody
public ResponseEntity<List<Invoice>> fetchInvoices(){
	List<Invoice> invoice = repository.findAll();
	if(invoice.size()==0) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;

	}
	return new ResponseEntity<>(invoice,HttpStatus.OK) ;
}
@GetMapping("/invoices/{id}")
@ResponseBody
public Optional<Invoice> findByInvoiceId(@PathVariable Integer id ){
	Optional<Invoice> invoice = repository.findById(id);
	return invoice;
}
}
