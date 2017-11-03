/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.telescopes;

import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import pns.kiam.sweb.controllers.telescope.TelescopeListUploaderController;

/**
 *
 * @author User
 */
@Stateless
@Named
public class TelescopeUploaderControl {

    @EJB
    private TelescopeListUploaderController controller;

    public TelescopeListUploaderController getController() {
	return controller;
    }

    public void setController(TelescopeListUploaderController controller) {
	this.controller = controller;
    }

    public void upload() throws IOException {

    }

}
