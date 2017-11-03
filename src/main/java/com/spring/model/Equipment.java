package com.spring.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity 
@Table(name="Equipment")
public class Equipment {
	@Id
	@GeneratedValue
	@Column(name="equipmentId")
	private Integer equipmentId;
	
	@Column(name="name")
	private String name;
	
	// Will add in later iteration
//	@Column(name="picture")
//	private Blob picture;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@ManyToMany(mappedBy="equipment")
	private Set<Exercise> exercises;
	
	public Equipment() {}

	public Equipment(Integer equipmentId, String name, 
			Integer quantity, Set<Exercise> exercises) {
		this.equipmentId = equipmentId;
		this.name = name;
		this.quantity = quantity;
		this.exercises = exercises;
	}
	

	/* Start of getters & setters */
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
//	public Blob getPicture() {
//		return picture;
//	}
//	public void setPicture(Blob picture) {
//		this.picture = picture;
//	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Set<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	/* End of getters & setters */
}
