package globoGymMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Qualification")
public class Qualification {
	@Id
	@GeneratedValue  
	@Column(name="qualId")
	private Integer qualId;

	@Column(name="name")
	private String name;

	/* Start of getters & setters */
	public Integer getQualId() {
		return qualId;
	}
	public void setQualId(Integer qualId) {
		this.qualId = qualId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* End of getters & setters */
}
