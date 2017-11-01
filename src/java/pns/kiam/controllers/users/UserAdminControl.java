/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.users;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import pns.kiam.Utils.DateTimeUtil;
import pns.kiam.entities.users.User;
import pns.kiam.sweb.controllers.user.UserController;

/**
 *
 * @author PSEVO tochka
 */
@Named
@Stateful
public class UserAdminControl implements Serializable {

    /**
     * Creates a new instance of UserAdminControl
     */
    @EJB
    private UserController controller;

    @EJB
    private DateTimeUtil dateTimeUtil;

    public UserAdminControl() {
    }

    public UserController getController() {
	return controller;
    }

    public void setController(UserController controller) {
	this.controller = controller;
    }

    public void prepareCreation() {
	controller.prepareCreation();
    }

    public DateTimeUtil getDateTimeUtil() {
	return dateTimeUtil;
    }

    public void rowDeSelect() {
	controller.rowDeSelect();
    }

    /**
     * Editing Table's row
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
	controller.onRowEdit(event);
    }

    /**
     * Removes the record(s) from Telescope table. if the "all " parameter is
     * true, removes all records else it is false removes only selected record
     * The represenation data in the lisr remove correspondently
     *
     * @param all
     */
    public void removeRow(boolean all) {
	controller.removeRow(all);
    }

    /**
     * Cancelling edit a row. Setting up a selection as null
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
	controller.onRowCancel(event);
    }

    /**
     * Row Select action
     */
    public void rowSelect(SelectEvent event) {
	controller.rowSelect(event);
    }

    /**
     * Row Select action by given Telescope
     *
     * @param t
     */
    public void rowSelectAction(User u) {
	controller.rowSelectAction(u);
    }

}
