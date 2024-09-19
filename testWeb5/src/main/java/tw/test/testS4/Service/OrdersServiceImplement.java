package tw.test.testS4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.test.testS4.Model.Cust;
import tw.test.testS4.Model.Orders;
import tw.test.testS4.Repository.CustRepository;
import tw.test.testS4.Repository.OrdersRepository;

@Service
public class OrdersServiceImplement {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private CustRepository custRepository;
	
	public Orders addOrder(Orders orders,Long custId) {
		Cust cust = custRepository.findById(custId).orElse(null);
		if(cust!=null) {
			orders.setCust(cust);
			return ordersRepository.save(orders);
		}else {
			return null;
		}
	}
	
	public void deleteOrder(Long id) {
		ordersRepository.deleteById(id);
	} 
	
}
