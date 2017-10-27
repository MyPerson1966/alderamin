/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.telescopes;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.controllers.users.UserControl;
import pns.kiam.entities.telescopes.Telescope;
import pns.kiam.sweb.controllers.telescope.TelescopeController;

/**
 *
 * @author PSEVO tochka
 */
@Named
@RequestScoped
public class TelescopeControlSelection {

    @EJB
    private TelescopeController controller;
    @Inject
    private UserControl userControl;

    /**
     * Creates a new instance of TelescopeControlSelection
     */
//    public TelescopeControlSelection() {
//    }
    @PostConstruct
    public void init() {

    }

    public TelescopeController getController() {
	return controller;
    }

    public void selectTelescope(Telescope t) {
	System.out.println("   Selected " + t);
	System.out.println("   Size of userControl.getUserController().getTelescopeList() " + userControl.getUserController().getTelescopeList().size());
	userControl.getUserController().getTelescopeList().add(t);
    }
}
