package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import java.util.List;

import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Order;

@Service
public interface OrderService {
	
	Result addOrder(Order order);
	
	DataResult<List<Order>> getAllOrder();
	DataResult<List<Order>> getAllOrder(int pageNo, int pageSize);
	DataResult<List<Order>> findByCustomerID(int customerID);
	DataResult<List<Order>> findByShipNameAndCustomerID(String shipName , int customerID);
}
