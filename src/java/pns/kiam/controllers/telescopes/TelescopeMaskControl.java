/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.telescopes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import pns.kiam.entities.telescopes.TelescopeHorizontMask;
import pns.kiam.sweb.controllers.telescope.TelescopeMaskController;

/**
 *
 * @author PSEVO tochka
 */
@Stateless
@Named
public class TelescopeMaskControl {

    @EJB
    private TelescopeMaskController controller;

//    @PostConstruct
//    public void init() {
//        controller = new TelescopeMaskController();
//    }
    public TelescopeMaskController getController() {
	return controller;
    }

    public void setController(TelescopeMaskController controller) {
	this.controller = controller;
    }

    public void prepareCreation() {
	controller.prepareCreate();
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

    public void rowSelect(SelectEvent event) {
	controller.rowSelect(event);
    }

    public void rowSelectAction(TelescopeHorizontMask t) {
	controller.rowSelectAction(t);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
