package com.ticketbot.sales;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * <h1>Sale Repository Definition</h1>
 * 
 * Facilitates communication with database.
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface SaleRepository extends CrudRepository<Sale, Integer> {
	
	/**
	 * Find By Email
	 * 
	 * @param email	Email
	 * 
	 * @return List of <code>Sale</code>
	 * */
	public List<Sale> findByEmail(String email);
}
