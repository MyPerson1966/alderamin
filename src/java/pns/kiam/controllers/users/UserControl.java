/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import pns.kiam.entities.users.User;
import pns.kiam.sweb.controllers.user.UserController;

/**
 *
 * @author PSEVO tochka
 */
@Named
//@RequestScoped
@ConversationScoped
public class UserControl implements Serializable {

    @Inject
    private Conversation conversation;
    @Inject
    private UserController userController;
    private String convURI = "";
    private User user;
    int step = 1;

    public UserControl() {
    }

    public UserController getUserController() {
	return userController;
    }

    public int getStep() {
	return step;
    }

    public void createUser() {
	System.out.println("      userController.getTelescopeList().size() " + userController.getTelescopeList().size());
//	user.setUserTelescopeList(userController.getTelescopeList());
//	userController.persistUser(user);
//	for (int k = 0; k < userController.getTelescopeList().size(); k++) {
//	    Telescope tmp = userController.getTelescopeList().get(k);
//	    System.out.println("                 tmp  " + tmp);
//	}

    }

    public void generateRNDPW() {
	userController.generatePW(true);
	//System.out.println("     userController.getPassw()   " + userController.getPassw() + "     userController.getLogin() " + userController.getLogin());
    }

    public String nextConversation() {
	//if (convURI.length() == 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	ExternalContext exc = fc.getExternalContext();
	HttpServletRequest req = (HttpServletRequest) exc.getRequest();
	convURI = req.getRequestURI();
	//}
	step++;
	System.out.println("    convURI  " + convURI);
	if (conversation.isTransient()) {
	    conversation.begin();
	    conversation.setTimeout(System.currentTimeMillis() / 2);
	}
	if (userController.getLogin().length() * userController.getPassw().length() * userController.getEmail().length() > 0) {
	    genUser();
	}
	return "usercreateend";
    }

    public String endConversation() {
	if (!conversation.isTransient()) {
	    conversation.end();
	}
	return "userdata?faces-redirect=true";
    }

    private void genUser() {
	user = new User();
	user.setEmail(userController.getEmail());
	user.setLogin(userController.getPassw());
	user.setPassword(userController.getPassw());
	user.setComment(userController.getComment());

    }

}
