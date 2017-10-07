package com.ticketbot.faces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbot.sales.SaleArchives;

/**
 * <h1>Sale Archive JPA Repository</h1>
 * 
 * <p>Adds basic CRUD functionality</p>
 * 
 * @author James Lawley
 * @version 1.0
 * */
public interface SaleArchiveJPARepository extends JpaRepository<SaleArchives, Integer> {

}
