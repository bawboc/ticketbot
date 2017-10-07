package com.ticketbot.faces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbot.sales.Sale;

/**
 * <h1>Sale JPA Repository</h1>
 * 
 * <p>Adds basic CRUD functionality</p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface SaleJPARepository extends JpaRepository<Sale, Integer> {

}
