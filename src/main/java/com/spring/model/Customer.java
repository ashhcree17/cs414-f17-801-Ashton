package com.spring.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;	// REQUIRED, starts with 2
	
	@Column(name="name")
	private String name;			// REQUIRED, first name
	
	@Column(name="lastName")
	private String lastName;		// REQUIRED
	
	@Column(name="customerAddressId")
	private Integer customerAddressId;
	
	@Column(name="phoneNumber")
	private Integer phoneNumber;	// Primary phone number
	
	@Column(name="email")
	private String email;		// REQUIRED
	
	@Column(name="insurance")
	private String insurance;
	
	@Column(name="membership")
	private MembershipStatus membership;
	
	//@Column(name="assignedRoutines")
	//private ArrayList<Routine> assignedRoutines;
	
	/* Start of getters & setters */
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public Integer getCustomerAddressId() {
		return customerAddressId;
	}
	public void setCustomerAddressId(Integer customerAddressId) {
		this.customerAddressId = customerAddressId;
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
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public MembershipStatus getMembership() {
		return membership;
	}
	public void setMembership(MembershipStatus membership) {
		this.membership = membership;
	}
//	public ArrayList<Routine> getAssignedRoutines() {
//		return assignedRoutines;
//	}
//	public void setAssignedRoutines(ArrayList<Routine> assignedRoutines) {
//		this.assignedRoutines = assignedRoutines;
//	}	
	/* End of getters & setters */
}
