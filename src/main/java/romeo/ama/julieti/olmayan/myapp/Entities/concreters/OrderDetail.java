package romeo.ama.julieti.olmayan.myapp.Entities.concreters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderDetails")
public class OrderDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	private long orderDetailID;
	
	@ManyToOne()
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="unit_price")
	private String unitPrice;
	
	@Column(name="quantity")
	private long quantity;
	
	@Column(name="dis_count")
	private long disCount;
	

}
