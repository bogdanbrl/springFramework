package com.bogdan.springdemo.serviceimpl;

import java.util.Random;

import com.bogdan.springdemo.service.IRecruitmentService;

public class ReferralRecruitmentServiceImpl implements IRecruitmentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n"+companyName+"'s " + departmentName + " hired "
				+ random.nextInt(numberOfRecruitments)+ " employees "
				+ "which were referred to company as employees.";
		return hiringFacts;
	}

}
