/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.satellites;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import pns.kiam.controllers.app.ConfigControl;
import pns.kiam.sweb.controllers.satelites.FileMeasuredController;

/**
 *
 * @author User
 */
@Named
@Stateless
public class FileMeasurementControl extends FileMeasuredController implements Serializable {

    @EJB
    private ConfigControl configControl;

    @PostConstruct
    public void init() {
        archivePath = configControl.getArchivePath();
        maxDaysFileLive = configControl.getMaxDaysFileLive();
    }

}
