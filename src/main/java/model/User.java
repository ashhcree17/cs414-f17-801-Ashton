package model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

abstract public class User {
	private Integer id;
	private String username;
	private String password;

	/* Start of getters & setters */
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
	/* End of getters & setters */

	// Abstract classes to be Overridden by Manager and Trainer classes
	abstract public <T> void create(T type);
	abstract public <T> void modify(T type);
	abstract public <T> T search(T type);
}