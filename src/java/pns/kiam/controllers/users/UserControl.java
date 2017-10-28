/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.entities.telescopes.Telescope;
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

    public UserControl() {
    }

    public UserController getUserController() {
	return userController;
    }

    public void createUser() {
	User u = new User();
	u.setEmail(userController.getLogin());
	u.setPassword(userController.getPassw());
	u.setComment(userController.getComment());
	u.setIsActive(userController.isActive());
	u.setUserType(userController.getUserType());
	u.setUserTelescopeList(userController.getTelescopeList());
	System.out.println("  USER  " + u);
	System.out.println("      userController.getTelescopeList().size() " + userController.getTelescopeList().size());
	for (int k = 0; k < userController.getTelescopeList().size(); k++) {
	    Telescope tmp = userController.getTelescopeList().get(k);
	    System.out.println("                 tmp  " + tmp);
	}

    }

    public void generateRNDPW() {
	userController.generatePW(true);
	System.out.println("   pw: " + userController.getPassw());
    }
}
