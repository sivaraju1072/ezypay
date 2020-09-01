package com.test.ezypay;

import java.util.List;

public class Subscription {

	private double amount;
	private String subscriptionType;
	private List<String> invoceDates;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public List<String> getInvoceDates() {
		return invoceDates;
	}
	public void setInvoceDates(List<String> invoceDates) {
		this.invoceDates = invoceDates;
	}
	
	
}
