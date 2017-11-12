/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.controllers.app.ConfigControl;
import pns.kiam.entities.users.User;
import pns.kiam.entities.users.UserType;
import pns.kiam.sweb.controllers.app.SsessionControl;
import pns.kiam.sweb.controllers.user.UserController;

/**
 * @author User
 */
@SessionScoped
@Named
public class UserLoginControl implements Serializable {

    @EJB
    private ConfigControl configControl;
    @Inject
    private SsessionControl ssessionCTRL;
    @EJB
    private UserController controller;

    private User currUser = new User();

    private boolean loginned = false;
    private boolean isSuperUser = false;

    private String login = "";
    private String password = "";

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public String getLogin() {
	return login;
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * Get the value of loginned
     *
     * @return the value of loginned
     */
    public boolean isLoginned() {
	ssessionCTRL.init();
	if (ssessionCTRL.getSession().getAttribute("loginned") != null) {
	    return (Boolean) ssessionCTRL.getSession().getAttribute("loginned");
	}
	return loginned;
    }

    public boolean isIsSuperUser() {
	return isSuperUser;
    }

    public User getCurrUser() {
	return currUser;
    }

    /**
     * Set the value of loginned
     *
     * @param loginned new value of loginned
     */
    public void setLoginned(boolean loginned) {
	this.loginned = loginned;
    }

    private boolean userExists() {
	System.out.println(" currUser  " + currUser);
	for (int k = 0; k < controller.getUserList().size(); k++) {
	    User tmp = controller.getUserList().get(k);
	    if (tmp.getLogin().equals(login) && tmp.getPassword().equals(password)) {
		if (tmp.isIsActive()) {
		    currUser = tmp;
		    System.out.println("  ------------------->  currUser  " + currUser);
		    return true;
		}
	    }
	}
	return false;
    }

    /**
     * try to login app
     */
    public String testLogin() {
	boolean bb = userExists();
//	ssessionCTRL.init();
	if ((login.equals(configControl.getConfigADMLogin()) && password.equals(configControl.getConfigAdmPassword())) || bb) {
	    currUser.setLogin(login);
	    currUser.setPassword(password);
	    if (currUser.getId() == null) {
		UserType ut = new UserType();
		ut.setName("ServiceAdmin");
		ut.setRights(511);
		currUser.setUserType(ut);
	    }
	    ssessionCTRL.getSession().setAttribute("loginned", true);
	    ssessionCTRL.getSession().setAttribute("login", login);
	    ssessionCTRL.getSession().setAttribute("isSuperAdmin", true);
	    ssessionCTRL.setTimeout(Integer.MAX_VALUE);
//	    ssessionCTRL.setTimeout(70);
//	    System.out.println(" ssessionCTRL.getSession() == null  =  "
//		    + (ssessionCTRL.getSession() == null) + "  " + ""
//		    + "  ssessionCTRL.getSession().getId() == null  "
//		    + (ssessionCTRL.getSession().getId() == null) + "   "
//		    + ssessionCTRL.getSession().getId() + "  / "
//		    + ssessionCTRL.getSession().getMaxInactiveInterval() + "   "
//		    + ssessionCTRL.isActive()
//	    );
	}
	return "/index.xhtml?faces-redirect=true";
    }

    /**
     * fixes that the session end and then logged Out
     */
    public boolean sessionUpToEnd() {
	long curr = System.currentTimeMillis();
	try {
	    if (ssessionCTRL.isActive() && ssessionCTRL.getSession() != null) {
		long last = ssessionCTRL.getSession().getLastAccessedTime();
		int duration = ssessionCTRL.getSession().getMaxInactiveInterval() * 1000;
		long finMoment = last + duration;
		long rest = (finMoment - curr) / 1000;
		if (rest < 50) {
		    System.out.println("==========================<<<<<50");

		}
		if (rest < 20) {
		    System.out.println(" doLogout ==========================<<<<<100");
		    return true;
		}
//		System.out.println("--->>" + new Date() + " last  " + new Date(last)
//			+ "     duration: " + duration + System.lineSeparator()
//			+ "     curr " + curr
//			+ "     finMoment: " + finMoment + "  rest: " + rest);
	    }
	} catch (IllegalStateException e) {
	}
	return false;
    }

    public String deLogin() {
	login = password = "";
	ssessionCTRL.getSession().setAttribute("loginned", null);
	ssessionCTRL.getSession().setAttribute("login", null);
	ssessionCTRL.getSession().setAttribute("isSuperAdmin", null);

	ssessionCTRL.sessionDestroy();
	return "/index.xhtml?faces-redirect=true";
    }
}
