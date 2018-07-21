package com.jga.models;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "p_type")
public class Person {

	
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String city;
	private String state;
	private int age;
	private Boolean gender;
	
	public Person() {
		super();
	}
	
	
	
	public Person(String username, String password, String firstName, String lastName, String email, String address,
			String city, String state, int age, Boolean gender) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.age = age;
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Boolean getGender() {
		return gender;
	}



	public void setGender(Boolean gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		this.password = password;
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
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void set(Person newPerson) {
		this.username = newPerson.username != null ?
				newPerson.username : this.username; 
		this.password = newPerson.password != null ?
				newPerson.password : this.password; 
		this.firstName = newPerson.firstName != null ?
				newPerson.firstName : this.firstName; 
		this.lastName = newPerson.lastName != null ?
				newPerson.lastName : this.lastName; 
	}

	
}

