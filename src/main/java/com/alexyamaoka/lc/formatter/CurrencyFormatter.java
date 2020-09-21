package com.alexyamaoka.lc.formatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
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
	
		
		String[] paymentAsString = text.split(" ");
		String amountAsString = paymentAsString[0];
		String currency = paymentAsString[1];
		
		Currency currencyUtil = Currency.getInstance(currency.toUpperCase());
		// usd
	
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		numberFormat.setCurrency(currencyUtil);
		numberFormat.format(new BigDecimal(amountAsString));
		
		
		PaymentAmount paymentAmount = new PaymentAmount();
		paymentAmount.setBillAmount(new BigDecimal(amountAsString));
		paymentAmount.setLocaleDefinition(currencyUtil.toString());
		
		
		
		
		return paymentAmount;
	}

}
