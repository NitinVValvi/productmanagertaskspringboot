package com.productmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productmanager.model.Manager;
@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

	public Manager findByEmailId(String emailId);

	public Manager findManagerByEmailIdAndPassword(String emailId, String password);

}
