package com.test.ezypay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.ezypay.service.SubscriptionService;

@RestController
public class SubscriptionApi {
	
	@Autowired
	SubscriptionService service;
	
	@PostMapping("/create")
	public Subscription create(@RequestBody Subscription subscription) {
		return  service.create(subscription);
	}

}
