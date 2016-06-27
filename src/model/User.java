/**
 * File name: User.java 
 * Purpose of file: This file contains the User class and its methods.
 * Copyright: This software follows GPL license. 
 **/

package model;
import java.util.Date;

/**
 * Class name: User
 * Purpose of class: This class is used to store all attributes from a user.
 **/
public class User {
	public int id;
	private String name;
	private String lastName;
	private String email;
	private String gender;
	private String password;
	private String nickname;
	private Date birthDate;
	
	public User() {
	}

	public User(int id, String name, String lastName, String email,
			String gender, String password, String nickname, Date birthDate) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.nickname = nickname;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
