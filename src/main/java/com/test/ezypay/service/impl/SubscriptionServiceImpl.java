package com.test.ezypay.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.ezypay.Subscription;
import com.test.ezypay.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Subscription create(Subscription sub) {
		List<String> invoiceDates = new ArrayList<>();
		switch (sub.getSubscriptionType()) {
		case "WEEKLY":
			   Calendar end = Calendar.getInstance();
			   end.add(Calendar.MONTH, 3);
			 Calendar c3 = Calendar.getInstance();
			   c3.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			   LocalDate dateBefores = LocalDate.of(c3.getTime().getYear(), c3.getTime().getMonth(), c3.getTime().getDate());
			   LocalDate dateAfters = LocalDate.of(end.getTime().getYear(), end.getTime().getMonth(), end.getTime().getDate());
			   long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefores, dateAfters);
			   for(int i=0;i<noOfDaysBetween;i++) {
				   Calendar c4 = Calendar.getInstance();
				   c4.add(Calendar.DAY_OF_MONTH, i);
				   if(c4.getTime().getDay()==2) {
					   invoiceDates.add(format.format(c4.getTime()));
				   }
			   }
			
			break;
		case "MONTHLY":
			   Calendar c1 = Calendar.getInstance();
			   c1.set(Calendar.DAY_OF_MONTH, 20);
			   for(int i=1;i<=3;i++) {
				   Calendar c2 = Calendar.getInstance();
				   c2.set(Calendar.DAY_OF_MONTH, c1.getTime().getDate());
				   c2.set(Calendar.MONTH, c1.getTime().getMonth());
				   c2.add(Calendar.MONTH, i);
				   invoiceDates.add(format.format(c2.getTime()));
			   }
			break;
		default:
				Calendar start = Calendar.getInstance();
			   Calendar end1 = Calendar.getInstance();
			   end1.add(Calendar.MONTH, 3);
			   LocalDate dateBefore = LocalDate.of(start.getTime().getYear(), start.getTime().getMonth(), start.getTime().getDate());
			   LocalDate dateAfter = LocalDate.of(end1.getTime().getYear(), end1.getTime().getMonth(), end1.getTime().getDate());
			   long noOfDaysBetween1 = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			   for(int i=1;i<=noOfDaysBetween1;i++) {
				   Calendar s = Calendar.getInstance();
				   s.add(Calendar.DATE, i);
				   invoiceDates.add(format.format(s.getTime()));
			   }
			break;
		}
		sub.setInvoceDates(invoiceDates);
		return sub;
	}

}
