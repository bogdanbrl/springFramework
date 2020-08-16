package com.criptex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.domain.Organization;

@Service
public class OrganizationService {

	@Autowired
	public OrganizationDao organizationDao;
	
	public List<Organization> getOrgList(){
		List<Organization> orgList = organizationDao.getAllOrganizations();
		return orgList;
	}
}
