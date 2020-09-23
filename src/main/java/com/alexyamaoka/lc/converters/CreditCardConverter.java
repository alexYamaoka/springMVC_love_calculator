package com.alexyamaoka.lc.converters;

import org.springframework.core.convert.converter.Converter;

import com.alexyamaoka.lc.api.CreditCard;

public class CreditCardConverter implements Converter<String, CreditCard>{

	@Override
	public CreditCard convert(String source) {
		
		String[] cardNumberArray = source.split("-");

		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigits(Integer.parseInt(cardNumberArray[0]));
		creditCard.setSecondFourDigits(Integer.parseInt(cardNumberArray[1]));
		creditCard.setThirdFourDigits(Integer.parseInt(cardNumberArray[2]));
		creditCard.setFourthFourDigits(Integer.parseInt(cardNumberArray[3]));
		
		return creditCard;
	}

}
