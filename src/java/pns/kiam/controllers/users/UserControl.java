/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.entities.users.User;
import pns.kiam.sweb.controllers.user.UserController;

/**
 *
 * @author PSEVO tochka
 */
@Named
@RequestScoped
public class UserControl {

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
    }

    public void generateRNDPW() {
	userController.generatePW(true);
	System.out.println("   pw: " + userController.getPassw());
    }
}
