package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import java.util.List;

import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Customer;

public interface CustomerService {
	
	Result addCustomer(Customer customer);
	Result deleteCustomer(long customerID);
	
	DataResult<List<Customer>> getAllCustomer();
	DataResult<List<Customer>> findByCustomerID(long customerID);
	DataResult<List<Customer>> findByCity(String city);
	DataResult<List<Customer>> findByCountary(String countary);
	
	

}
