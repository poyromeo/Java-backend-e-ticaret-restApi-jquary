package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.OrderService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessResult;
import romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks.OrderDao;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Order;

@Service
public class OrderManager implements OrderService{
	
	private OrderDao orderDao;
	@Autowired
	public OrderManager(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}
	
	@Override
	public Result addOrder(Order order) {
		this.orderDao.save(order);
		return new SuccessResult("Data Eklendi.");
	}
	@Override
	public DataResult<List<Order>> getAllOrder() {
		return new SuccessDataResult<List<Order>>
		(this.orderDao.findAll(),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Order>> getAllOrder(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Order>>
		(this.orderDao.findAll(pageable).getContent(),"Data Sayfa Numarasına Göre Listelendi.");
	}
	@Override
	public DataResult<List<Order>> findByCustomerID(int customerID) {
		return new SuccessDataResult<List<Order>>
		(this.orderDao.findByCustomerID(customerID));
	}
	@Override
	public DataResult<List<Order>> findByShipNameAndCustomerID(String shipName, int customerID) {
		return new SuccessDataResult<List<Order>>
		(this.orderDao.findByShipNameAndCustomerID(shipName, customerID));
	}
	

}
