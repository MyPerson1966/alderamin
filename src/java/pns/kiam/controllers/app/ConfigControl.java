/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import pns.FileActor;
import pns.kiam.controllers.users.UserLoginControl;
import pns.kiam.sweb.controllers.app.XXParserSWEB;
import pns.kiam.sweb.controllers.satelites.FileMeasuredController;
import pns.xmlUtils.SXParser;

/**
 *
 * @author User
 */
@Stateless
@Named
public class ConfigControl {

    @Inject
    private UserLoginControl userLoginControl;

    //private FileMeasuredController
    @EJB
    private XXParserSWEB xxparser;

    private String configADMLogin;

    private String configAdmPassword;
    private String archivePath = "";

    /**
     * Get the value of configAdmPassword
     *
     * @return the value of configAdmPassword
     */
    public String getConfigAdmPassword() {
        return configAdmPassword;
    }

    /**
     * Get the value of configADMLogin
     *
     * @return the value of configADMLogin
     */
    public String getConfigADMLogin() {
        return configADMLogin;
    }

    public XXParserSWEB getXxparser() {
        return xxparser;
    }

    @PostConstruct
    public void init() {

        xxparser.setDocUrl("appsconf/s-web.xml");

//        System.out.println("   " + xxparser.getDocUrl());
        try {
            xxparser.build();
            configADMLogin = xxparser.getLogin();
            configAdmPassword = xxparser.getPassword();
            archivePath = xxparser.getArchivePath();
            System.out.println("   -------->> " + archivePath + "   " + xxparser.getArchivePath());
            xxparser.getFileMeasuredController().readArchiveFileDir();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Killing and stop a session
     */
    public void sessionKill() {
        System.out.println("  xxparser.getSsessionControl(): " + (xxparser.getSsessionControl() == null) + "   "
                + xxparser.getSsessionControl().getSession().getId());
        if (xxparser.getSsessionControl().getSession() != null) {
            System.out.println("Session to kill: " + xxparser.getSsessionControl().getSession().getId());
            xxparser.getSsessionControl().sessionDestroy();
        }
    }

//    /**
//     * Starting a session for time secunds
//     *
//     * @param time
//     */
//    public void sessionStart(int time) {
//        System.out.println("  xxparser.getSsessionControl(): " + (xxparser.getSsessionControl() == null));
//
//        if (xxparser.getSsessionControl() == null) {
//            xxparser.getSsessionControl().init();
//            xxparser.getSsessionControl().setTimeout(time);
//        } else {
//            Long LL = xxparser.getSsessionControl().getSession().getCreationTime();
//            xxparser.getSsessionControl().setTimeout(time);
//            System.out.println("  session start " + new Date() + "   " //+ //LL
//                    + "   " + xxparser.getSsessionControl().getSession().getMaxInactiveInterval());
//        }
//
//    }
    public void navigate(String gotoURL) {
        System.out.println("   gotoURL  " + gotoURL);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        //NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
    }
}
