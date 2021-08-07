/*package com.order.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.model.Invoice;

@FeignClient(value="invoice-service")
public interface MyFeignClient {

	@GetMapping("/invoices")
	List<Invoice> fetchInvoices();

}
*/