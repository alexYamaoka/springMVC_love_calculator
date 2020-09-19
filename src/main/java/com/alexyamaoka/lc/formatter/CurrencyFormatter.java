package com.alexyamaoka.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alexyamaoka.lc.api.Billing;
import com.alexyamaoka.lc.api.CreditCard;

public class CurrencyFormatter  implements Formatter<Billing>{

	@Override
	public String print(Billing object, Locale locale) {
		
		return null;
	}

	@Override
	public Billing parse(String text, Locale locale) throws ParseException {
		
		// bind usd to $ or Euro to euro sign
		
		
		
		
		
		
		return null;
	}

}
