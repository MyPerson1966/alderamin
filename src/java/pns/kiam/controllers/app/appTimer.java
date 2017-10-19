/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pns.kiam.sweb.controllers.app.SsessionControl;
import pns.kiam.sweb.controllers.app.XXParserSWEB;

/**
 *
 * @author User
 */
@Stateless
public class appTimer {

//    @EJB
//    private SsessionControl ssessionControl;
    @EJB
    private XXParserSWEB xxparser;
    @EJB
    private ConfigControl configControl;

    private boolean mustDelogin = false;

    // @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/5", persistent = true)
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

}
