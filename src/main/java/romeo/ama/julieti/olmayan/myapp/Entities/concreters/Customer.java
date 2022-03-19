package romeo.ama.julieti.olmayan.myapp.Entities.concreters;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="customers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orders"})
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
	private long customerID;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contanct_name")
	private String contanctName;
	
	@Column(name="contanct_title")
	private String contanctTitle;
	
	@Column(name="address")
	private String address;
	
	@Column(name="region")
	private String region;
	
	@Column(name="city")
	private String city;
	
	@Column(name="countary")
	private String countary;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> order;
	
	

}
