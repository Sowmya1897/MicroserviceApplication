package com.order.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


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

import com.order.model.Order;
import com.order.model.Product;
import com.order.repository.OrderRepository;
import com.order.repository.ProductRepository;


@RestController
@RequestMapping("/order")
public class OrderContoller {
@Autowired
OrderRepository reposirory;
@Autowired
ProductRepository proreposirory;


@PostMapping("/saveOrders/{pid}")
public String saveProducts(@Valid @PathVariable Integer pid,@RequestBody Order order){
String message;
Product p_id = proreposirory.findById(pid).get();
order.setPid(pid);
int ord= reposirory.save(order).getOid();

	if(ord>0) {
		
		message ="Order confirmed successfully with id "+ord+".";
	}
	else {
		message = "Your Order is cancelled!";
	}
	return message;
	
	/*}else  {
		if(order.getOrder_status().equalsIgnoreCase("Confirmed")) {
			order.setP_id(product.getPid());
		}*/
	
}


@GetMapping("/orders")
@ResponseBody
public  ResponseEntity<List<Order>> fetchOrders() {
	//JSONObject jsonObject = new JSONObject();
	List<Order> order = reposirory.findAll();
	///jsonObject.put("product", new JSONObject(myFeignClient.fetchInvoices()));
	if(order.size()==0) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;

	}
	return new ResponseEntity<>(order,HttpStatus.OK) ;
	
}

@GetMapping("/orders/{oid}")
@ResponseBody
public Optional<Order> findByOrderById(@PathVariable Integer oid ){
	Optional<Order> order = reposirory.findById(oid);
	return order;
}
}
