package globoGymMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Qualification")
public class Qualification {
	private String name;

	public Qualification(String name) {
		super();
		this.name = name;
	}

	/* Start of getters & setters */
	@Id
	@GeneratedValue  
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* End of getters & setters */
}
