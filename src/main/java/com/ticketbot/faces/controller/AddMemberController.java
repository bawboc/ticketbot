package com.ticketbot.faces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.emails.EmailResponse;
import com.ticketbot.faces.repository.MemberJPARepository;
import com.ticketbot.members.Member;

/**
 * <h1>Add a New Member</h1>
 * <p>
 * This Controller accompanies the New Member
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="memberAddController")
@ELBeanName(value="memberAddController")
@Join(path="/memberForm", to="/member-form.jsf")
public class AddMemberController {
	
	@Autowired
	private MemberJPARepository memberRepository;
	
	@Autowired
	private EmailResponse emailResponse;
	
	private Boolean hasRequestedAdmin;
	
	private Member member = new Member();
	
	/**
	 * The saves the newly created <code>Member</code>
	 * 
	 * @return redirect
	 * */
	public String Save() {
		memberRepository.save(member);
		if	(hasRequestedAdmin) {
			emailResponse.addAdminResponse(member);
		}
		member = new Member();
		return "/login.xhtml?faces-redirection=true";
	}

	/**
	 * Return current <code>Member</code>
	 * 
	 * @return member
	 * */
	public Member getMember() {
		return member;
	}

	/**
	 * Sets current <code>Member</code>
	 * 
	 * @param member	Member
	 * */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Check if new request needs Administrative
	 * permissions.
	 * 
	 *  @return <code>Boolean</code>
	 * */
	public Boolean getHasRequestedAdmin() {
		return hasRequestedAdmin;
	}

	/**
	 * Set check for administrative access request.
	 * 
	 * @param hasRequestedAdmin	Request
	 * */
	public void setHasRequestedAdmin(Boolean hasRequestedAdmin) {
		this.hasRequestedAdmin = hasRequestedAdmin;
	}
}
