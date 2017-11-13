package csu.springmvc.model;

//import java.sql.Blob;

public class Equipment {

  private int equipmentid;
  private String name;
//  private Blob picture;
  private int quantity;
  
  public int getEquipmentid() {
    return equipmentid;
  }

  public void setEquipmentid(int equipmentid) {
    this.equipmentid = equipmentid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public Blob getPicture() {
//    return picture;
//  }
//
//  public void setPicture(Blob picture) {
//    this.picture = picture;
//  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
