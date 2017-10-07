package com.ticketbot.faces.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.faces.repository.MemberJPARepository;
import com.ticketbot.members.Member;

/**
 * <h1>List Members</h1>
 * <p>
 * This Controller accompanies the Member List
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="memberList")
@ELBeanName(value="memberList")
@Join(path="/memberList", to="/member-list.jsf")
public class MemberListController {
	
	@Autowired
	private MemberJPARepository memberRepository;
	
	private List<Member> members;
	
	/**
	 * Initialize Properties
	 * */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadDate() {
		members = memberRepository.findAll();
	}
	
	/**
	 * Get Members
	 * 
	 * @return List of <code>Member</code>s.
	 * */
	public List<Member> getMembers(){
		return members;
	}

}
