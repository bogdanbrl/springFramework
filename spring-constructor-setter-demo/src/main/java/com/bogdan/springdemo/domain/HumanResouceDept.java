package com.bogdan.springdemo.domain;

import com.bogdan.springdemo.service.IRecruitmentService;

public class HumanResouceDept implements IDepartment {

	private String deptName;
	private IRecruitmentService recruitmentService;
	private Organization organiation;
	
	public HumanResouceDept(IRecruitmentService recruitmentService, Organization organiation) {
		this.recruitmentService = recruitmentService;
		this.organiation = organiation;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitEmployees(organiation.getCompanyName(),
				deptName, numberOfRecruitments);
		return hiringFacts;
			
	}

}
