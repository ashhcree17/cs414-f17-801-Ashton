package globoGymMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="Manager")
public class Manager extends User {
	private Integer id;			// Starts with 0
	private String username;
	private String password;
	
	private String name;			// First name
	private String lastName;
	private Integer phoneNumber;	// Primary phone number
	private String email;
	private Address address;
	private String insurance;
	
	/* Creates a Manager instance with username and password set 
	 * by User during no-id sign in 
	 */
	public Manager(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/* Start of getters & setters */
	@Id
	@GeneratedValue  
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password") // ***** hesdfjaslfjaslfjl STOP **/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="phoneNumber")
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="address")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Column(name="insurance")
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	/* End of getters & setters */

	@Override
	public <T extends User> void create(T type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends User> void modify(T type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends User> T search(T type) {
		// TODO Auto-generated method stub
		return null;
	}
}
