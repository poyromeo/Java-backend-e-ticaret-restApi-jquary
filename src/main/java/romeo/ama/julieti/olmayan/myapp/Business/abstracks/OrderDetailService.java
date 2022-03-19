package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import java.util.List;

import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.OrderDetail;

@Service
public interface OrderDetailService {
	
	DataResult<List<OrderDetail>> getAllOrderDetail();
	DataResult<List<OrderDetail>> findByOrderIDOrProductID(int orderID, int productID);
	

}
