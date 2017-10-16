package globoGymMS;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	private String username;
	private String password;
	
	private String name;		// first name
	private String lastName;
	private Integer phoneNumber;	// primary phone number
	private String email;
	private Address address;
	private String id;
	private String insurance;
	
	/* Creates a Manager instance by using the username and password
	   set by the User during sign in (credentials must NOT be connected
	   to a Trainer id attribute) */
	public Manager(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// Creates a Trainer instance and sets its attributes
	public Manager(String name, String lastName, Address address, Integer phoneNumber, String email, String id,
			String insurance) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
		this.insurance = insurance;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
}
