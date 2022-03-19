package romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	List<Customer> findByCustomerID(long customerID);
	List<Customer> findByCity(String city);
	List<Customer> findByCountary(String countary);
	
	
	

}
