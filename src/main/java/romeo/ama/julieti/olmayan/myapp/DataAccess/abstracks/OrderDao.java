package romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

	List<Order> findByCustomerID(int customerID);

	@Query("From Product where shipName=:shipName or customer.customerID=:customerID")
	List<Order> findByShipNameAndCustomerID(String shipName, int customerID);
	
	

}
