package globoGymMS;

import java.awt.Image;

public class EquipmentBean {
	private Integer equipmentId;
	private String name;
	private Image picture;
	private Integer quantity;
	
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
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
}
