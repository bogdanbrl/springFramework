package com.criptex.spring.domain;

import com.criptex.spring.service.RecruitmentService;

public class HumanResourceDeptarment implements Department {

	private String departmentName;
	private RecruitmentService recruitmentService;  // recruitmentService is a dependency and we can 
													// inject a particular implementation - constructor based injection
	private Organization organization;				// this is another dependency and we can also inject it 
													// using constructor injection
	
	public HumanResourceDeptarment(RecruitmentService recruitmentService, Organization organization) {
		super();
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitEmployees(organization.getCompanyName(), departmentName, numberOfRecruitments);
		return hiringFacts;
	}

}
