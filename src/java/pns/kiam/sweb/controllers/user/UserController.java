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
import javax.ejb.Stateless;
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
@Stateless
@Named
public class UserController extends AbstractController implements Serializable {

    private User user;
    private List<User> userList = new ArrayList<>();
    private CriteriaQuery<User> cq;

    @PostConstruct
    public void init() {
	try {
	    cb = em.getCriteriaBuilder();
	    cq = cb.createQuery(User.class);
	    userList = loadAllUsers();
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
