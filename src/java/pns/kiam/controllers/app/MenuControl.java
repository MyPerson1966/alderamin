/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pns.kiam.controllers.users.UserLoginControl;
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
    @Inject
    private UserLoginControl userLoginCTRL;

//    public MenuControl() {
//    }
    public String navigste(String gotoURL) {
//	if (userLoginCTRL.sessionUpToEnd()) {
//	    return userLoginCTRL.deLogin();
//	}
	return gotoURL;
//	try {
////	    System.out.println("   " + System.lineSeparator() + System.lineSeparator()
////		    + "   ssessionCTRL.isActive()  " + ssessionCTRL.isActive() + "   '" + System.lineSeparator()
////		    //  + "    ssessionCTRL.getSession() == null " + (ssessionCTRL.getSession() == null) + "" + System.lineSeparator()
////		    + "    ssessionCTRL.isNeedToDelogin() " + ssessionCTRL.isNeedToDelogin()
////	    );
//
////	    System.out.println("");
////	    System.out.println("");
////	    System.out.println("");
////	    System.out.println("  ssessionCTRL.isActive()   " + ssessionCTRL.isActive());
////	    System.out.println("  ssessionCTRL.isNeedToDelogin()  " + ssessionCTRL.isNeedToDelogin());
////	    System.out.println("");
////	    System.out.println("");
////	    System.out.println("");
//	    if (ssessionCTRL.isActive() && ssessionCTRL.isNeedToDelogin()) {
//		gotoURL = "/index";
//		ssessionCTRL.sessionDestroy();
//	    }
//
//	    System.out.println("   gotoURL " + gotoURL);
////	return "/index";
//	    return gotoURL;
//	} catch (IllegalStateException e) {
//	}
//	return "/index";
    }
}
