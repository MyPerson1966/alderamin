/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.sweb.controllers.user.UserTypeController;

/**
 *
 * @author PSEVO tochka
 */
@Named
@SessionScoped
public class UserTypeControl implements Serializable {

    /**
     * Creates a new instance of UserTypeControl
     */
    @Inject
    private UserTypeController controller;

    public UserTypeControl() {
    }

    public UserTypeController getController() {
	return controller;
    }

    public void setController(UserTypeController controller) {
	this.controller = controller;
    }

}
