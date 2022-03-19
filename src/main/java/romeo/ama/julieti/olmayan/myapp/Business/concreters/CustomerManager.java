package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.CustomerService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessResult;
import romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks.CustomerDao;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Customer;

@Service
public class CustomerManager implements CustomerService{
	
	private CustomerDao customerDao;
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	
	@Override
	public Result addCustomer(Customer customer) {
		this.customerDao.save(customer);
		return new SuccessResult("Müşteriler Listelendi.");
	}
	
	@Override
	public Result deleteCustomer(long customerID) {
		this.customerDao.deleteById(customerID);;
		return new SuccessResult("Müşteri silindi.");
	}
	
	@Override
	public DataResult<List<Customer>> getAllCustomer() {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findAll(),"Müşteriler Listelendi.");
	}
	
	@Override
	public DataResult<List<Customer>> findByCustomerID(long customerID) {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findByCustomerID(customerID),"Müşteriler Listelendi.");
	}
	
	@Override
	public DataResult<List<Customer>> findByCity(String city) {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findByCity(city),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Customer>> findByCountary(String countary) {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findByCountary(countary),"Data Listelendi.");
	}
	

}
