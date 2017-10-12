

import java.util.ArrayList;

public class Trainer {
	private String username;
	private String password;
	
	private String name;		// first name
	private String lastName;
	private Integer phoneNumber;	// primary phone number
	private String email;
	private Address address;
	private String id;
	private String insurance;
	private WorkSchedule workSchedule;
	private ArrayList<String> qualifications;
	
	// Creates a Trainer instance and sets its attributes
	public Trainer(String name, String lastName, Integer phoneNumber, String email, Address address, String id,
			String insurance, WorkSchedule workSchedule, ArrayList<String> qualifications) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
		this.insurance = insurance;
		this.workSchedule = workSchedule;
		this.qualifications = qualifications;
	}
	
	/* Start of getters & setters */
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
	public WorkSchedule getWorkSchedule() {
		return workSchedule;
	}
	public void setWorkSchedule(WorkSchedule workSchedule) {
		this.workSchedule = workSchedule;
	}
	public ArrayList<String> getQualifications() {
		return qualifications;
	}
	public void setQualifications(ArrayList<String> qualifications) {
		this.qualifications = qualifications;
	}
	/* End of getters & setters */
}
