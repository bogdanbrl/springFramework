package com.criptex.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.criptex.spring.domain.Organization;

public interface OrganizationDao {

	// set the data-source that will be required to create a connection to the database
	public void setDataSource (DataSource ds);
	
	// create a record in the organization table
	public boolean create(Organization org);
	
	// retreive a single organiation
	public Organization getOrganization(Integer id);
	
	// retreive all organiations from the table
	public List<Organization> getAllOrganizations();
	
	// delete a specific organization from the table
	public boolean delete(Organization org);
	
	//update an existing organization
	public boolean update(Organization org);
	
	public void cleanup();
} 
