package member.controller;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import member.dao.LoginDao;
import member.model.MemberBean;
import member.service.ManageService;

@Controller

public class ManageController {
	
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@Autowired
	private ManageService manageService;
	
	public Session getConnection() {
		return this.factory.getCurrentSession();
	}

	public ManageController() { 	}

	
	@RequestMapping(path = "/Manage", method = RequestMethod.GET)	
	public String manage() {
		manageService.TestBean();
		return "Manage";
	}
	
	

}
