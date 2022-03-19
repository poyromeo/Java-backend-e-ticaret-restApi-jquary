package romeo.ama.julieti.olmayan.myapp.Api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.OrderService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Order;

@RestController
@RequestMapping(value="/Api/orders")
public class OrderController {
	
	private OrderService orderService;
	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/addOrder")
	public Result addOrder(@RequestBody Order order) {
		return this.orderService.addOrder(order);
	}
	
	@GetMapping("/getAllOrder")
	public DataResult<List<Order>> getAllOrder() {
		return this.orderService.getAllOrder();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Order>> getAllOrder(int pageNo, int pageSize) {
		return this.orderService.getAllOrder(pageNo, pageSize);
	}
	
	@GetMapping("/findByCustomerID")
	public DataResult<List<Order>> findByCustomerID(@RequestParam int customerID) {
		return this.orderService.findByCustomerID(customerID);
	}
	
	@GetMapping("/findByShipNameAndCustomerID")
	public DataResult<List<Order>> findByShipNameAndCustomerID(@RequestParam("shipName") String shipName, @RequestParam int customerID) {
		return this.orderService.findByShipNameAndCustomerID(shipName, customerID);
	}
	
	
	
	
	
	
	
	
	

}
