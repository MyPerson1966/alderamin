/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.kiam.sweb.controllers.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pns.kiam.entities.users.User;
import pns.kiam.sweb.controllers.AbstractController;
import pns.kiam.sweb.utils.MessageUtils;

/**
 *
 * @author PSEVO tochka
 */
@Stateful
@Named
public class UserController extends AbstractController implements Serializable {

    private User user;
    private List<User> userList = new ArrayList<>();
    private CriteriaQuery<User> cq;

    private String login = "", passw = "", passwNEW = "";

    @PostConstruct
    public void init() {
	try {
	    cb = em.getCriteriaBuilder();
	    cq = cb.createQuery(User.class);
	    userList = loadAllUsers();
	    generatePW(true);
	} catch (NullPointerException e) {
	}

    }

    private List loadAllUsers() {

	Root<User> res = cq.from(User.class);
	cq.select(res);
	cq.orderBy(cb.asc(res.get("id")));
	TypedQuery<User> Q = em.createQuery(cq);
	System.out.println(" " + Q.getResultList().size());

	(new MessageUtils()).messageGenerator(" User Type Number is: " + Q.getResultList().size(), "");
	return Q.getResultList();
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public List<User> getUserList() {
	return userList;
    }

    public void setUserList(List<User> userList) {
	this.userList = userList;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassw() {
	return passw;
    }

    public void setPassw(String passw) {
	this.passw = passw;
    }

    public String getPasswNEW() {
	return passwNEW;
    }

    public void setPasswNEW(String passwNEW) {
	this.passwNEW = passwNEW;
    }

    /**
     * generate a new password for a user
     *
     * @param random if true , than the new pw is not empty
     */
    public void generatePW(boolean random) {
	if (random) {
	    int k = pns.utils.numbers.RInts.rndInt(12, 17);
	    for (int i = 0; i < 5; i++) {
		passwNEW += pns.utils.strings.RStrings.rndLetterString();
	    }
	    passwNEW = passwNEW.substring(0, k);
	} else {
	    passwNEW = "";
	}
	System.out.println("  passw " + passw);
    }

    public String validateUser() {
	System.out.println("userList.size() == 0 " + (userList.size() == 0));
	if (userList.size() == 0) {
	    return "/users/usercreate";
	}
	if (userExists()) {
	    return "/users/userdata";
	} else {
	    return "index";
	}
    }

    private boolean userExists() {
	if (userList.size() == 0) {
	    return false;
	}
	int npp = 0;
	for (int k = 0; k < userList.size(); k++) {
	    User tmp = userList.get(k);
	    if (login.equals(tmp.getPassword()) && passw.equals(tmp.getUserTelescope().getIdentifier())) {
		npp++;
	    }
	}
	return npp == 1;
    }

    private void createUser() {

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
