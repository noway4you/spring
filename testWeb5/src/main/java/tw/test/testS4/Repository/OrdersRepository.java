package tw.test.testS4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.test.testS4.Model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long>{

}
