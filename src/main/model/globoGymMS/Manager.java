package globoGymMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="Manager")
public class Manager {
//	private Integer id;			// REQUIRED, starts with 0
//	private String username;
//	private String password;
//	
//	private String name;			// REQUIRED, First name
//	private String lastName;		// REQUIRED
//	private Integer phoneNumber;	// Primary phone number
//	private String email;		// REQUIRED
//	private Address address;
//	private String insurance;
//	
//	/* Creates a Manager instance with username and password set 
//	 * by User during no-id sign in 
//	 */
//	public Manager(Integer id, String username, String password) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}
//
//	/* Start of getters & setters */
	@Id
	@SequenceGenerator(name="EMP_SEQ_0", allocationSize=1, initialValue=000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")  
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;			// First name
	
	@Column(name="lastName")
	private String lastName;

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
//
//	@Override
//	public <T> void create(T type) {
//		if (type == Trainer.class) {
//			// take type.attributes and add to db?
//		} else if (type == Customer.class) {
//			
//		} else if (type == Equipment.class) {
//			
//		}
//	}
//
//	@Override
//	public <T> void modify(T type) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <T> T search(T type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
