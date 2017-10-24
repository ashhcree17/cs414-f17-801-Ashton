package globoGymMS;

import java.util.ArrayList;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TrainerBean {
	private Integer id;			// REQUIRED, starts with 1
	private String username;
	private String password;
	
	private String name;			// REQUIRED, first name
	private String lastName;		// REQUIRED
	private Address address;
	private Integer phoneNumber;	// Primary phone number
	private String email;		// REQUIRED
	private String insurance;
	private ArrayList<WorkSchedule> workSchedule;
	private ArrayList<Qualification> qualifications;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
}
