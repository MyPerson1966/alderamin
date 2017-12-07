/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.satellites;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import pns.kiam.entities.satellites.SatelliteMeasurement;
import pns.kiam.sweb.controllers.satelites.SatelliteMeasurerementsController;

/**
 *
 * @author User
 */
@Named
@SessionScoped
public class SatelliteMeasurementControl extends SatelliteMeasurerementsController implements Serializable {

    /**
     * Creates a new instance of SatelliteMeasurementControl
     */
    public SatelliteMeasurementControl() {

//
    }

}
