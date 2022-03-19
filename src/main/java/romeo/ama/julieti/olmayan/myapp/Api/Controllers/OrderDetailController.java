package romeo.ama.julieti.olmayan.myapp.Api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.OrderDetailService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.OrderDetail;

@RestController
@RequestMapping(value="/Api/orderDeteals")
public class OrderDetailController {
	
	private OrderDetailService orderDetailService;
	
	@Autowired
	public OrderDetailController(OrderDetailService orderDetailService) {
		super();
		this.orderDetailService = orderDetailService;
	}

	@GetMapping("/getAllOrderDetail")
	public DataResult<List<OrderDetail>> getAllOrderDetail() {
		return this.orderDetailService.getAllOrderDetail();
	}
	
	@GetMapping("/findByOrderIDOrProductID")
	public DataResult<List<OrderDetail>> findByOrderIDOrProductID(@RequestParam int orderID, @RequestParam int productID) {
		return this.orderDetailService.findByOrderIDOrProductID(orderID, productID);
	}
	

}
