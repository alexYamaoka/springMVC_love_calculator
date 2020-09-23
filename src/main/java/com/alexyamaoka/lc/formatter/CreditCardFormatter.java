package com.alexyamaoka.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.alexyamaoka.lc.api.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard>{

	@Override
	public String print(CreditCard object, Locale locale) {
		String cardAsString = object.getFirstFourDigits() + "-" + object.getSecondFourDigits() + "-"
							+ object.getThirdFourDigits() + "-" + object.getFourthFourDigits();
	
		System.out.println("inside credit card formatter print method");
		return cardAsString;
	}

	@Override
	public CreditCard parse(String text, Locale locale) throws ParseException {
		System.out.println("inside credit card formatter");
		
		String[] cardNumberArray = text.split("-");
		
		CreditCard creditCard = new CreditCard();
		
		creditCard.setFirstFourDigits(Integer.parseInt(cardNumberArray[0]));
		creditCard.setSecondFourDigits(Integer.parseInt(cardNumberArray[1]));
		creditCard.setThirdFourDigits(Integer.parseInt(cardNumberArray[2]));
		creditCard.setFourthFourDigits(Integer.parseInt(cardNumberArray[3]));
		
		return creditCard;
	}
}
