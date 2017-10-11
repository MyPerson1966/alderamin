/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.admincontrollers.telescope;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import pns.kiam.globalcontrollers.telescope.*;

/**
 *
 * @author PSEVO tochka
 */
@Stateless
@Named
public class TelescopeControl {

    @EJB
    private TelescopeController controller;
    @EJB
    private TelescopeMaskController maskController;
    @EJB
    private TelescopeListUploaderController listUploaderController;

    public TelescopeController getController() {
	return controller;
    }

    public void setController(TelescopeController controller) {
	this.controller = controller;
    }

}
