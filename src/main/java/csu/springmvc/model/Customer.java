package csu.springmvc.model;

import csu.springmvc.model.MembershipStatus;

public class Customer {

  private int customerid;
  private String name;
  private String lastname;
  private String email;
  private String insurance;
  private int phonenumber;
  private MembershipStatus membership;
  
  public int getCustomerid() {
    return customerid;
  }

  public void setCustomerid(int customerid) {
    this.customerid = customerid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
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

  public int getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(int phonenumber) {
    this.phonenumber = phonenumber;
  }

  public MembershipStatus getMembership() {
    return membership;
  }

  public void setMembership(MembershipStatus membership) {
    this.membership = membership;
  }
}
