package com.ticketbot.faces.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ticketbot.members.MemberRepository;
import com.ticketbot.members.Member;
 
/**
 * <h1>Login</h1>
 * <p>
 * This Controller accompanies the Login
 * JSF Page.
 * </p>
 * @author James Lawley
 * @version 1.0
 * */
@Scope(value="session")
@Component(value="userLoginView")
@ELBeanName(value="userLoginView")
@Join(path="/", to="/login.jsf")
public class UserLoginController {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ServletContext servletContext;
	
	private String username;
    
    private String password;
 
    /**
     * Get User Name
     * 
     * @return <code>String</code>
     * */
    public String getUsername() {
        return username;
    }
 
    /**
     * Set User Name
     * 
     * @param username	User Name
     * */
    public void setUsername(String username) {
        this.username = username;
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
     * Login
     * 
     * Checks User Credentials and logs in or redirects to sign up page.
     * Saves <code>Member</code> in Context for later use.
     * 
     * @return redirect
     * */
    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        
        Member member =  memberRepository.findByEmail(username);
         
        if(member != null && password != null && password.equals(member.getPassword())) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("member", member);
            servletContext.setAttribute("member", member);
            return "/event-list.xhtml?faces-redirection=true";
        } else if (member != null && ((password != null && !password.equals(member.getPassword())) || (password == null))) {
        	message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        	return "/login.xhtml?faces-redirection=true";
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            return "/member-form.xhtml?faces-redirection=true";
        }
    }
    
    /**
     * Create
     * 
     * Redirects to Sign up form.
     * 
     * @return redirect
     * */
    public String create() {
    	return "/member-form.xhtml?faces-redirection=true";
    }
}
