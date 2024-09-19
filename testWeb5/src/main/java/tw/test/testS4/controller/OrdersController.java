package tw.test.testS4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS4.Model.Orders;
import tw.test.testS4.Service.OrdersServiceImplement;

@RequestMapping("/orders")
@RestController
public class OrdersController {

	@Autowired
	private OrdersServiceImplement ordersServiceImplement;
	
	@PostMapping("/add/{custId}")
	public Orders addCust(@RequestBody Orders orders,@PathVariable Long custId) {
		return ordersServiceImplement.addOrder(orders,custId);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOrders(@PathVariable Long id) {
		ordersServiceImplement.deleteOrder(id);
	}
	
}
