package romeo.ama.julieti.olmayan.myapp.Api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.CustomerService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Customer;

@RestController
@RequestMapping(value="/Api/customers")
public class CustomerController {

	private CustomerService customerService;
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("addCustomer")
	public Result addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
	
	@DeleteMapping(value="/customerID")
	public Result deleteCustomer(@PathVariable long customerID) {
		return this.customerService.deleteCustomer(customerID);
	}
	
	@GetMapping("/getAllCustomer")
	public DataResult<List<Customer>> getAllCustomer() {
		return this.customerService.getAllCustomer();
	}
	
	@GetMapping("/findByCustomerID")
	public DataResult<List<Customer>> findByCustomerID(@RequestParam long customerID) {
		return this.customerService.findByCustomerID(customerID);
	}
	
	@GetMapping("/findByCustomerCity")
	public DataResult<List<Customer>> findByrCity (@RequestParam String city) {
		return this.customerService.findByCity(city);
	}
	@GetMapping("/findByCustomerCountary")
	public DataResult<List<Customer>> findByCountary(@RequestParam String countary) {
		return this.customerService.findByCountary(countary);
	}
	

	
	
	
	
}
