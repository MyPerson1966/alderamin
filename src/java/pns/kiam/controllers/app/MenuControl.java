/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import pns.kiam.sweb.controllers.app.SsessionControl;
import pns.kiam.sweb.controllers.app.XXParserSWEB;

/**
 *
 * @author User
 */
@Named
@RequestScoped
public class MenuControl {

    /**
     * Creates a new instance of MenuControl
     */
    @EJB
    private XXParserSWEB xxparser;
    @Inject
    private SsessionControl ssessionCTRL;

//    public MenuControl() {
//    }
    public String navigste(String gotoURL) {
        System.out.println("   " + System.lineSeparator() + System.lineSeparator()
                + "   ssessionCTRL.isActive()  " + ssessionCTRL.isActive() + "   '" + System.lineSeparator()
                + "    ssessionCTRL.getSession() == null " + (ssessionCTRL.getSession() == null) + "" + System.lineSeparator()
                + "    ssessionCTRL.isNeedToDelogin() " + ssessionCTRL.isNeedToDelogin()
        );
        if (ssessionCTRL.isActive() && ssessionCTRL.isNeedToDelogin()) {
            return "/index";
        }

        return gotoURL;
    }
}
