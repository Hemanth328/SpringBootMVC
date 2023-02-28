package com.org.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishService {

	@Override
	public String generateWishMessage(String user) {
		// get system date and time
		LocalDateTime ldt = LocalDateTime.now();
		
		//get hour in 24hrs format
		int hour = ldt.getHour();
		
		if(hour < 12)
			return "Good Morning "+user;
		else if(hour < 16)
			return "Good Afternoon "+user;
		else if(hour < 20)
			return "Good Evening "+user;
		else
			return "Good Night "+user;
		

	}

}
