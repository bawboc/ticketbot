package com.ticketbot.admin;

import org.springframework.data.repository.CrudRepository;

/**
 * <h1><code>AdminRepository</code> Definition</h1>
 * 
 * Adds basic CRUD functionality
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	
	/**
	 * Find Admin By Email
	 * 
	 * @param email Email
	 * 
	 * @return <code>Admin</code>
	 * */
	public Admin findByEmail(String email);
}
