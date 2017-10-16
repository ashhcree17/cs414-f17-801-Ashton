package globoGymMS;

import java.util.ArrayList;

public class Trainer {
	private String username;
	private String password;
	
	private String name;		// first name
	private String lastName;
	private Address address;
	private Integer phoneNumber;	// primary phone number
	private String email;
	private String id;
	private String insurance;
	private ArrayList<WorkSchedule> workSchedule;
	private ArrayList<Qualification> qualifications;
	
	// Creates a Trainer instance and sets its attributes
	public Trainer(String name, String lastName, Address address, Integer phoneNumber, String email, String id,
			String insurance, ArrayList<WorkSchedule> workSchedule, ArrayList<Qualification> qualifications) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
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
	public ArrayList<WorkSchedule> getWorkSchedule() {
		return workSchedule;
	}
	public void setWorkSchedule(ArrayList<WorkSchedule> workSchedule) {
		this.workSchedule = workSchedule;
	}
	public ArrayList<Qualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(ArrayList<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	/* End of getters & setters */
}
