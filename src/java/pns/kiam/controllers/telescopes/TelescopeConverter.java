/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.controllers.telescopes;

import java.io.Serializable;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

/**
 *
 * @author User
 */
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import pns.kiam.entities.telescopes.Telescope;
import pns.kiam.sweb.controllers.AbstractController;
import pns.kiam.sweb.controllers.telescope.TelescopeController;

@FacesConverter("telescopeConverter")
@SessionScoped
public class TelescopeConverter implements Converter, Serializable {

    @EJB
    private TelescopeController controller;
    @Inject
    private TelescopeControl telescopeControl;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) throws ConverterException {
        long tID = 0;
        if (value != null && value.trim().length() > 0) {
            value = value.trim();
            try {
//                tID = Long.parseLong(value.trim());
//                System.out.println("                     tID   " + tID);

                Telescope ts = null;
                System.out.println("  VALUE  " + value);
                String[] parts = value.split("\\{");
                value = parts[1].split("\\}")[0];
                //System.out.println("  New VALUE  " + value);
                ts = parseTelescopeString(value);

//                Telescope ts = (Telescope) em.find(Telescope.class, tID);
//                System.out.println("    ts " + ts);
//                Telescope ts = controller.searchTelescope(tID);
                //System.out.println("   ts: " + ts);
                return ts;
                //} catch (NumberFormatException e) {
            } catch (NullPointerException ee) {
                System.out.println("          v " + value);
            }
        } else {
        }
        System.out.println("          VVVv " + value + "   +tID  " + tID + "    ");

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//        if (object != null) {
//            return String.valueOf(((Theme) object).getId());
//        } else {
//            return null;
//        }
        return null;
    }

    private Telescope parseTelescopeString(String s) {
        int k = 0;
        Telescope ts = new Telescope();
        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            //System.out.println(k + "   " + tok);

            String[] tokParts = tok.split("=");
            try {
                if (k == 0) {
                    try {
                        long id = Long.parseLong(tokParts[1]);
                        ts.setId(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 1) {
                    try {
                        long id = Long.parseLong(tokParts[1]);
                        ts.setIdentifier(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 2) {
                    try {
                        ts.setLocation(tokParts[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 3) {
                    try {
                        ts.setName(tokParts[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 4) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setX(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 5) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setY(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 6) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setZ(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 7) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setHeight(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 8) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setLatitude(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }

                if (k == 9) {
                    try {
                        double id = Double.parseDouble(tokParts[1]);
                        ts.setLongitude(id);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 10) {
                    try {
                        ts.setDescription(tokParts[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (k == 11) {
                    try {
                        ts.setComment(tokParts[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }

            } catch (NumberFormatException e) {
            }
            k++;
        }
        return ts;
        /*
Info:   0     id=2475
Info:   1    identifier=10003
Info:   2    location=Mondy
Info:   3    name=Монды АЗТ-14
Info:   4    x=-752.0464182274
Info:   5    y=3897.3479261745
Info:   6    z=4978.3907247915
Info:   7    height=2.008
Info:   8    latitude=51.622227
Info:   9    longitude=100.921765
Info:   10    description=
Info:   11    comment=
         */

    }
}
