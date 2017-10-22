package globoGymMS;

import java.util.ArrayList;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Entity // This tells Hibernate to make a table out of this class
//@Table(name="Trainer")
public class Trainer extends User {
	private Integer id;			// Starts with 1
	private String username;
	private String password;
	
	private String name;			// First name
	private String lastName;
	private Address address;
	private Integer phoneNumber;	// Primary phone number
	private String email;
	private String insurance;
	private ArrayList<WorkSchedule> workSchedule;
	private ArrayList<Qualification> qualifications;
	
	// Creates a Trainer instance and sets its attributes
	public Trainer(Integer id, String name, String lastName, Address address, Integer phoneNumber, String email,
			String insurance, ArrayList<WorkSchedule> workSchedule, ArrayList<Qualification> qualifications) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.insurance = insurance;
		this.workSchedule = workSchedule;
		this.qualifications = qualifications;
	}
	
	/* Start of getters & setters */
//	@Id
//	@SequenceGenerator(name="EMP_SEQ_1", allocationSize=1, initialValue=100)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ_1")   
//	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}
//	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Column(name="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	@Column(name="address")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
//	@Column(name="phoneNumber")
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	@Column(name="insurance")
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
//	@Column(name="workSchedule")
//	@ElementCollection(targetClass=WorkSchedule.class)
	public ArrayList<WorkSchedule> getWorkSchedule() {
		return workSchedule;
	}
	public void setWorkSchedule(ArrayList<WorkSchedule> workSchedule) {
		this.workSchedule = workSchedule;
	}
//	@Column(name="qualifications")
	public ArrayList<Qualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(ArrayList<Qualification> qualifications) {
		this.qualifications = qualifications;
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
