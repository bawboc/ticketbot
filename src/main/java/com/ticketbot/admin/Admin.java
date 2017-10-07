package com.ticketbot.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * <h1><code>Admin</code> Definition</h1>
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Entity
public class Admin {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String email;
	
	/**
	 * Default Constructor
	 * */
	public Admin() {}
	
	/**
	 * Constructor with Email
	 * 
	 * @param email Email
	 * */
	public Admin(String email) {
		super();
		this.email = email;
	}

	/**
	 * Constructor with Id and Email
	 * 
	 * @param id Id
	 * @param email Email
	 * */
	public Admin(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	/**
	 * Get Id
	 * 
	 * @return id
	 * 
	 * */
	public int getId() {
		return id;
	}

	/**
	 * Set Id
	 * 
	 * @param id Id
	 * */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get Email
	 * 
	 * @return email
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Set Email
	 * 
	 * @param email Email
	 * 
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
}
