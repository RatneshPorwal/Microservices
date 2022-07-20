package com.ratnesh.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratnesh.microservice.limitsservice.bean.Limits;
import com.ratnesh.microservice.limitsservice.configuration.LimitConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	LimitConfiguration limitConfiguration;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits (limitConfiguration.getMin(), limitConfiguration.getMax());
	//return new Limits (1, 1000);
	}
}
