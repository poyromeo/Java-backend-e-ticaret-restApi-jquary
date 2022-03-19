package romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import romeo.ama.julieti.olmayan.myapp.Entities.concreters.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

	@Query("From Product where order.orderID=:orderID or product.productID=:productID")
	List<OrderDetail> findByOrderIDOrProductID(int orderID, int productID);
	

}
