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
		
		// logic to separate country code with number  1-310xxxxxxx 
		String[] phoneNumberArray = text.split("-");
		Phone phone = new Phone();
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setUserNumber(phoneNumberArray[1]);
		
		System.out.println("country code: " + phone.getCountryCode());
		System.out.println("phone number: " + phone.getUserNumber());
		
		return phone;
	}

}
