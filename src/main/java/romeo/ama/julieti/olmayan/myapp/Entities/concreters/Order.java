package romeo.ama.julieti.olmayan.myapp.Entities.concreters;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orderDetails"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
	private long orderID;
	
	@ManyToOne()
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="order_date")
	private long orderDate;
	
	@Column(name="required_date")
	private long requiredDate;
	
	@Column(name="shiped_date")
	private long shippedDate;
	
	@Column(name="ship_name")
	private String shipName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="ciry")
	private String city;
	
	@Column(name="region")
	private String region;
	
	@Column(name="countary")
	private String countary;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	
	
	

}
