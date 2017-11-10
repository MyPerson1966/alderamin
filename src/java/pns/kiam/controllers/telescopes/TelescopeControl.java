/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.telescopes;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pns.kiam.entities.telescopes.Telescope;
import pns.kiam.entities.users.User;
import pns.kiam.sweb.controllers.app.XXParserSWEB;
import pns.kiam.sweb.controllers.telescope.TelescopeController;
import pns.kiam.sweb.controllers.user.UserController;

/**
 *
 * @author PSEVO tochka
 */
@Stateful
@Named
public class TelescopeControl {

    @EJB
    private TelescopeController controller;

    @EJB
    private UserController userController;

    @EJB
    private XXParserSWEB xxparser;

    public TelescopeController getController() {
        return controller;
    }

    public void setController(TelescopeController controller) {
        this.controller = controller;
    }

    public void prepareCreation() {
        controller.prepareCreation();
    }

    public void rowDeSelect() {
        controller.rowDeSelect();
    }

    /**
     * Detecting the given Telescope t as used
     *
     * @param Telescope t
     * @return
     */
    public Boolean telescopeInUse(Telescope t) {
        if (userController.getTelescopeUserList().contains(t)) {
            return true;
        }
        return false;
    }

    /**
     * Detecting the given Telescope t as used Exclude the telescopes of the
     * given user u;
     *
     * @param Telescope t
     * @return
     */
    public Boolean telescopeInUse(Telescope t, User u) {
        boolean res = telescopeInUse(t);
        if (res && !u.getUserTelescopeList().contains(t)) {
            return true;
        }
//        if (userController.getTelescopeUserList().contains(t)) {
//            return true;
//        }
        return false;
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
    public void rowSelect() {
        controller.rowSelect();
    }

    /**
     * Row Select action by given Telescope
     *
     * @param t
     */
    public void rowSelectAction(Telescope t) {
        controller.rowSelectAction(t);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void businessMethod() {
        System.out.println(xxparser.getSsessionControl() == null);
    }
}
