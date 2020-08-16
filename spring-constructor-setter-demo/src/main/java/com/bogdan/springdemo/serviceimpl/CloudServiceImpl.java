package com.bogdan.springdemo.serviceimpl;

import java.util.Random;

import com.bogdan.springdemo.service.IBusinessService;

public class CloudServiceImpl implements IBusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization "+ companyName +
				" offers world class Cloud computing infrastructure. "
				+"\nAnnual income exceeds " + random.nextInt(revenue) + " dollars";
		return service;
	}

}
