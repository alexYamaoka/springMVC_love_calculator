package com.alexyamaoka.lc.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alexyamaoka.lc.api.PaymentAmount;


public class CurrencyFormatter  implements Formatter<PaymentAmount>{

	@Override
	public String print(PaymentAmount object, Locale locale) {
		System.out.println("inside currency formatter print method");
		
		return object.getBillAmount() + "";
	}

	@Override
	public PaymentAmount parse(String text, Locale locale) throws ParseException {
		
		// bind usd to $ or Euro to euro sign
		System.out.println("inside currency formatter");
		System.out.println("string passes on: " + text);
		
		String[] paymentAsString = text.split(" ");
		
		String amountAsString = paymentAsString[0];
		String currency = paymentAsString[1];
		
		System.out.println("amount: " + amountAsString);
		System.out.println("currency: " + currency);
		
		
		PaymentAmount paymentAmount = new PaymentAmount();
		paymentAmount.setBillAmount(new BigDecimal(amountAsString));
		paymentAmount.setLocaleDefinition(currency);
		
		
		if (currency.equals("usd")) {
			
			NumberFormat usNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
			
			System.out.println("usNumberFormat: " + usNumberFormat.format(new BigDecimal(amountAsString)));
		}
		
		
		
		
		
	
		
		return paymentAmount;
	}

}
