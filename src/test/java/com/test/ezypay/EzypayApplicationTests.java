package com.test.ezypay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.ezypay.service.SubscriptionService;

@SpringBootTest
class EzypayApplicationTests {

	@Autowired
	SubscriptionService service;
	@Test
	void contextLoads() {
		List<String> invoiceDates = new ArrayList<>();
		invoiceDates.add("01/09/2020");
		invoiceDates.add("08/09/2020");
		invoiceDates.add("15/09/2020");
		invoiceDates.add("22/09/2020");
		invoiceDates.add("29/09/2020");
		
		Subscription sub = new Subscription();
		sub.setAmount(10.00);
		sub.setSubscriptionType("WEEKLY");
		Subscription s = service.create(sub);
		
		Subscription sub1= new Subscription();
		sub1.setAmount(10.00);
		sub1.setSubscriptionType("WEEKLY");
		sub1.setInvoceDates(invoiceDates);
		assertEquals(sub1.getInvoceDates(), s.getInvoceDates());
	}

}
