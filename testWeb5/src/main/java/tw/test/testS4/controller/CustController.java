package tw.test.testS4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS4.Model.Cust;
import tw.test.testS4.Model.Orders;
import tw.test.testS4.Service.CustServiceImplement;

@RequestMapping("/cust")
@RestController
public class CustController {

	@Autowired
	private CustServiceImplement custServiceImplement;
	
	@PostMapping("/add")
	public Cust addCust(@RequestBody Cust cust) {
		return custServiceImplement.addCust(cust);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCust(@PathVariable Long id) {
		custServiceImplement.deleteCust(id);
	}
	
	@GetMapping("/getOrders/{id}")
	public List<Orders> getOrders(@PathVariable Long id) {
		return  custServiceImplement.getAllOrders(id);
	}
	
}
