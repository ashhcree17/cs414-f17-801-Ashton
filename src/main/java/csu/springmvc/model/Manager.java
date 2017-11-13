package csu.springmvc.model;

public class Manager {

  private int managerid;
  private String username;
  private String password;
  private String name;
  private String lastname;
  private String email;
  private String insurance;
  private int phonenumber;
  
  public int getManagerid() {
    return managerid;
  }

  public void setManagerid(int managerid) {
    this.managerid = managerid;
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
    this.password = password;
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
}
