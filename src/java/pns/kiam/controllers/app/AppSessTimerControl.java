/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pns.kiam.sweb.controllers.app.SsessionControl;
import pns.kiam.sweb.controllers.app.XXParserSWEB;

/**
 *
 * @author User
 */
@Stateless
public class AppSessTimerControl {

    @Inject
    private SsessionControl ssessionCTRL;
    private boolean mustDelogin = false;

    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/5", persistent = true)
    public void appTimer() {

        long curr = System.currentTimeMillis();

        System.out.println("   " + new Date() + "     ssessionCTRL.isFinished()  " + ssessionCTRL.isActive()
        );
        //System.out.println(new Date() + "  !ssessionCTRL.isFinished() " + !ssessionCTRL.isFinished() + "   ssessionCTRL.getSession() == null " + (ssessionCTRL.getSession() == null));

//        if (!ssessionCTRL.isFinished() && ssessionCTRL.getSession() != null) {
//            long last = ssessionCTRL.getSession().getLastAccessedTime();
//
//            System.out.println("Timer event: " + new Date() + " last  " + new Date(last));
//        }
    }

}
