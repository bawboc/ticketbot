package com.ticketbot.members;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * <h1>Member Entity Definition</h1>
 * 
 * 
 * @author James Lawley
 * @version 1.0
 * */
@CrossOrigin
@Entity
public class Member {

	@Id
	@GeneratedValue
	private int Id;
	
	private String firstName;
	private String lastName;
	private String organization;
	private String address;
	private String phoneNumber;
	
	@Column(unique=true)
	private String email;
	private String password;
	
	/**
	 * Default Constructor
	 * */
	public Member() {}
	
	/**
	 * Constructor With Id
	 * 
	 * @param id 	Id
	 * */
	public Member(int id) {
		super();
		Id = id;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
	}

	/**
	 * Constructor
	 * 
	 * @param id			Id
	 * @param firstName		First Name
	 * @param lastName		Last Name
	 * @param email			Email
	 * @param password		Password
	 * */
	public Member(int id, String firstName, String lastName, String email, String password) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	/**
	 * Get Id
	 * 
	 * @return <code>Integer</code>
	 * */
	public int getId() {
		return Id;
	}

	/**
	 * Set Id
	 * 
	 * @param id	Id
	 * */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * Get First Name
	 * 
	 * @return <code>String</code>
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set First Name
	 * 
	 * @param firstName	First Name
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * Get Last Name
	 * 
	 * @return <code>String</code>
	 * */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set Last Name
	 * 
	 * @param lastName	Last Name
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get Email
	 * 
	 * @return <code>String</code>
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Set Email
	 * 
	 * @param email	Email
	 * */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get Password
	 * 
	 * @return <code>String</code>
	 * */
	public String getPassword() {
		return password;
	}

	/**
	 * Set Password
	 * 
	 * @param password	Password
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get Organization
	 * 
	 * @return <code>String</code>
	 * */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Set Organization
	 * 
	 * @param organization	Organization
	 * */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	
	/**
	 * Get Address
	 * 
	 * @return <code>String</code>
	 * */
	public String getAddress() {
		return address;
	}

	/**
	 * Set Address
	 * 
	 * @param address	Address
	 * */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get Phone Number
	 * 
	 * @return <code>String</code>
	 * */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set Phone Number
	 * 
	 * @param phoneNumber	Phone Number
	 * */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
