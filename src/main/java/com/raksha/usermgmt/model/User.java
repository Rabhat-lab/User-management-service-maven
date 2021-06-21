package com.raksha.usermgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
	
	//we want id as the primary key
	@Id
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "firstName")
	//first name should not exceed 100 chars
	@Size(min = 2, max = 100,message = "Name should have min 2 or max 100 characters")
	private String firstName;
	
	@Column(name = "lastName")
	//last name should not exceed 100 chars
	@Size(min = 2, max = 100,message = "Name should have min 2 or max 100 characters")
	private String lastName;
	
	@Column(name = "occupation")
	private String occupation;
	
	//constructor to access the new User obj
	public User(int userid, String firstName, String lastName, String occupation) {
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
	}
	
	//generating the getters and setters
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
