package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.OrderDetailService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks.OrderDetailDao;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService {
	
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	public OrderDetailManager(OrderDetailDao orderDetailDao) {
		super();
		this.orderDetailDao = orderDetailDao;
	}
	
	
	@Override
	public DataResult<List<OrderDetail>> getAllOrderDetail() {
		return new SuccessDataResult<List<OrderDetail>>
		(this.orderDetailDao.findAll(),"Data Listelendi.");
	}	
	
	@Override
	public DataResult<List<OrderDetail>> findByOrderIDOrProductID(int orderID, int productID) {
		return new SuccessDataResult<List<OrderDetail>>
		(this.orderDetailDao.findByOrderIDOrProductID(orderID, productID));
	}
	

}
