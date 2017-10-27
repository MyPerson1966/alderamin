/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pns.kiam.sweb.controllers.app.SsessionControl;

/**
 *
 * @author User
 */
@Stateless
public class AppSessTimerControl {

    @Inject
    private SsessionControl ssessionCTRL;
    private boolean mustDelogin = false;

    // @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/10", persistent = true)
    public void appTimer() {

	long curr = System.currentTimeMillis();
	if (curr / 10000 % 3 == 0) {
	    System.out.println("   " + new Date() + "   ssessionCTRL.isActive()  " + ssessionCTRL.isActive() + "   '"
		    + "   ssessionCTRL.getSession() == null " + (ssessionCTRL.getSession() == null) + System.lineSeparator()
		    + "   ssessionCTRL.isNeedToDelogin() " + ssessionCTRL.isNeedToDelogin()
	    );
	}
	//System.out.println(new Date() + "  !ssessionCTRL.isFinished() " + !ssessionCTRL.isFinished() + "   ssessionCTRL.getSession() == null " + (ssessionCTRL.getSession() == null));
	try {
	    if (ssessionCTRL.isActive() && ssessionCTRL.getSession() != null) {
		long last = ssessionCTRL.getSession().getLastAccessedTime();
		int duration = ssessionCTRL.getSession().getMaxInactiveInterval() * 1000;
		long finMoment = last + duration;
		long rest = (finMoment - curr) / 1000;
		if (rest < 100) {
		    System.out.println("==========================<<<<<100");
		    ssessionCTRL.setNeedToDelogin(true);
		}
//		System.out.println("--->>" + new Date() + " last  " + new Date(last)
//			+ "     duration: " + duration + System.lineSeparator()
//			+ "     curr " + curr
//			+ "     finMoment: " + finMoment + "  rest: " + rest);
	    }
	} catch (IllegalStateException e) {
	}
    }

}
