package globoGymMS;

import java.awt.Image;

public class Equipment {
	private String name;
	private Image picture;
	private Integer quantity;

	// Creates an Equipment instance and sets its attributes
	public Equipment(String name, Image picture, Integer quantity) {
		super();
		this.name = name;
		this.picture = picture;
		this.quantity = quantity;
	}
	
	/* Start of getters & setters */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getPicture() {
		return picture;
	}
	public void setPicture(Image picture) {
		this.picture = picture;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/* End of getters & setters */
}
