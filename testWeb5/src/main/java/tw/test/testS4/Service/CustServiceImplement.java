package tw.test.testS4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.test.testS4.Model.Cust;
import tw.test.testS4.Model.Orders;
import tw.test.testS4.Repository.CustRepository;

@Service
public class CustServiceImplement {

	@Autowired
	private CustRepository custRepository;
	
	public Cust addCust(Cust cust) {
		return custRepository.save(cust);
	}
	
	public void deleteCust(Long id) {
		custRepository.deleteById(id);
	}
	
	public List<Orders> getAllOrders(Long id){
		Cust cust = custRepository.findById(id).orElse(null);
		return cust.getOrders();
	}
	
}
