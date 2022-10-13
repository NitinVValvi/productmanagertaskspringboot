package com.productmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanager.model.Manager;
import com.productmanager.repo.ManagerRepo;

@Service
public class ManagerService {
	@Autowired
	private ManagerRepo managerrepo;

	
	public Manager registerManager(Manager manager) {
		return managerrepo.save(manager);
	}
	
	public Manager findManagerByEmailId(String emailId) {
		
		return managerrepo.findByEmailId(emailId);
	}
	
	public Manager findManagerByEmailIdAndPassword(String emailId,String password) {
		
		return managerrepo.findManagerByEmailIdAndPassword(emailId,password);
	}
}
