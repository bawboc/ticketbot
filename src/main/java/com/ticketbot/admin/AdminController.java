package com.ticketbot.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbot.admin.AdminService;

/**
 * <h1><code>AdminController</code> Definition</h1>
 * Provides REST functionality.
 * 
 * @author James Lawley
 * @version 1.0
 * */
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	/**
	 * Add Admin
	 * 
	 * @param email Email
	 * */
	@RequestMapping("/admin/add")
	public void AddAdmin(@RequestParam String email) {
		adminService.addAdmin(new Admin(email));
	}
}
