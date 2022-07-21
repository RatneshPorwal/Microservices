package com.ratnesh.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController { 
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(
			@PathVariable String from,
			@PathVariable String to
			)
	{
		/*
		 * CurrencyExchange currentExchange = new
		 * CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		 * 
		 * currentExchange.setEnvironment(environment.getProperty("local.server.port"));
		 */
		
		CurrencyExchange currentExchange =repository.findByFromAndTo(from, to);
		
		if(currentExchange==null)
			throw new RuntimeException("Unable to find the record");
		
		return currentExchange;
	}

}
