package globoGymMS;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="Address")
public class Address {
	private Integer address_id;
	private String street1;		// main street (i.e., 123 Main St.)
	private String street2;		// secondary street (i.e., Apt. 123)
	private String city;
	private String state;
	private Integer zipCode;
	
	// Creates an Address instance and sets its attributes
	public Address(Integer address_id, String street1, String street2, String city, 
			String state, Integer zipCode) {
		super();
		this.address_id = address_id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/* Start of getters & setters */	@Id
	@GeneratedValue  
	@Column(name="address_id")
	public Integer getId() {
		return address_id;
	}
	public void setId(Integer address_id) {
		this.address_id = address_id;
	}	
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	/* End of getters & setters */
}
