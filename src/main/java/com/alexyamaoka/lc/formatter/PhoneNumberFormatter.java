package com.alexyamaoka.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alexyamaoka.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		System.out.println("inside parse method of Phone Number Formatter");
		
		// logic
		return null;
	}

}
