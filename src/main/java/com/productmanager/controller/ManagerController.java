package com.productmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productmanager.model.Manager;
import com.productmanager.service.ManagerService;

@RestController

public class ManagerController {
	@Autowired
	private ManagerService managerservice;
	
	@PostMapping("/registermanager")
	@CrossOrigin(origins = "http://localhost:4200")
	public Manager registerManager(@RequestBody Manager manager) throws Exception {
		String tempemailId = manager.getEmailId();
		if(tempemailId != null && !"".equals(tempemailId)) {
		Manager managerobj =	managerservice.findManagerByEmailId(tempemailId);
		if(managerobj!=null) {
			throw new Exception ("manager with " +tempemailId+"already exist");
		}
		}
		
		Manager managerobj = null;
		managerservice.registerManager(manager);
		
		return managerobj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Manager loginManager(@RequestBody Manager manager) throws Exception {
		String tempemailId =manager.getEmailId();
		String tempPass = manager.getPassword();
		Manager managerObj=null;
		if(tempemailId !=null && tempPass!=null) {
		 managerObj = managerservice.findManagerByEmailIdAndPassword(tempemailId, tempPass);
		}
		if(managerObj == null) {
			throw new Exception("wrong data");
		}
		return managerObj;
	}
}
