package com.bogdan.springdemo.serviceimpl;

import java.util.Random;

import com.bogdan.springdemo.service.IBusinessService;

public class EcommerceSeviceImpl implements IBusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " +companyName
				+" provides an outstanding ecommerce platform."
				+"\nthe annual revenue exceeds "+random.nextInt(revenue)+" dollars";
		return service;
	}

}
