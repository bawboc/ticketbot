package com.ticketbot.faces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.faces.repository.SaleArchiveJPARepository;
import com.ticketbot.sales.SaleArchives;

import java.util.List;

/**
 * <h1>List Sale Archives</h1>
 * <p>
 * This Controller accompanies the Sale Archives
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="saleArchiveList")
@ELBeanName(value="saleArchiveList")
@Join(path="/saleArchiveList", to="/sale-archive-list.jsf")
public class SaleArchivesFacesController {

	@Autowired
	private SaleArchiveJPARepository saleArchivesRepository;
	
	private List<SaleArchives> sales;
	
	/**
	 * Initialize Properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		sales = saleArchivesRepository.findAll();
	}

	/**
	 * Get Sales
	 * 
	 * @return List of <code>Sale</code>
	 * */
	public List<SaleArchives> getSales() {
		return sales;
	}

	/**
	 * Set Sales
	 * 
	 * @param sales	List of Sales
	 * */
	public void setSales(List<SaleArchives> sales) {
		this.sales = sales;
	}
}
