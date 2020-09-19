package com.alexyamaoka.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alexyamaoka.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		// need to use print for data binding.
		// program flow reaches print method when data binding
		
		System.out.println("inside the print method of phone number formatter");
		String phoneNumber = object.getCountryCode() + " " + object.getUserNumber();
		
		return phoneNumber;
	}

	
	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		System.out.println("inside parse method of Phone Number Formatter");
		
		// check whether the number consists of "-" for country code 
		// if not found, add 1 for default country code 
		
		Phone phone = new Phone();
		int index = text.indexOf('-');
		String[] phoneNumberArray = text.split("-");
		
		if (index == -1 || text.startsWith("-")) {
			phone.setCountryCode("1");
			
			if (text.startsWith("-")) {
				phone.setUserNumber(phoneNumberArray[1]);
			}
			else {
				phone.setUserNumber(phoneNumberArray[0]);
			}
			
		}
		else {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		
		return phone;
	}
}
