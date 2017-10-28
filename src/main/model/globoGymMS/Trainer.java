package globoGymMS;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Trainer")
public class Trainer extends User {
	@Id
	@SequenceGenerator(name="EMP_SEQ_1", allocationSize=1, initialValue=100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ_1")   
	@Column(name="id")
	private Integer id;			// REQUIRED, starts with 1
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;			// REQUIRED, first name
	
	@Column(name="lastName")
	private String lastName;		// REQUIRED
	
	@Column(name="address")
	private Address address;
	
	@Column(name="phoneNumber")
	private Integer phoneNumber;	// Primary phone number
	
	@Column(name="email")
	private String email;		// REQUIRED
	
	@Column(name="insurance")
	private String insurance;
//	
//	@Column(name="workSchedule")
////	@ElementCollection(targetClass=WorkSchedule.class)
//	private ArrayList<WorkSchedule> workSchedule;
//	
//	@Column(name="qualifications")
//	private ArrayList<Qualification> qualifications;
	
//	/* Start of getters & setters */
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
//	public ArrayList<WorkSchedule> getWorkSchedule() {
//		return workSchedule;
//	}
//	public void setWorkSchedule(ArrayList<WorkSchedule> workSchedule) {
//		this.workSchedule = workSchedule;
//	}
//	public ArrayList<Qualification> getQualifications() {
//		return qualifications;
//	}
//	public void setQualifications(ArrayList<Qualification> qualifications) {
//		this.qualifications = qualifications;
//	}
//	/* End of getters & setters */

	@Override
	public <T> void create(T type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <T> void modify(T type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <T> T search(T type) {
		// TODO Auto-generated method stub
		return null;
	}
}
