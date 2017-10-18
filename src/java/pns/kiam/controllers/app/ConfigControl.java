/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.app;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import pns.FileActor;
import pns.kiam.controllers.users.UserLoginControl;
import pns.kiam.sweb.controllers.app.XXParserSWEB;
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

    @EJB
    private XXParserSWEB xxparser;

    private String configADMLogin;

    private String configAdmPassword;

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

    @PostConstruct
    public void init() {

        xxparser.setDocUrl("appsconf/s-web.xml");
//        System.out.println("   " + xxparser.getDocUrl());
        try {
            xxparser.build();
            configADMLogin = xxparser.getLogin();
            configAdmPassword = xxparser.getPassword();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
