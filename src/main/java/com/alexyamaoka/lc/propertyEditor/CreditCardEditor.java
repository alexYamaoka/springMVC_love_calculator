package com.alexyamaoka.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.alexyamaoka.lc.api.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// is similar to the print method in the formatter to display credit card inside webpage when it loads 
		
		return "xxxx-xxxx-xxxx-xxxx";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// is similar to the parse method in the formatter
		
		String[] cardNumberArray = text.split("-");

		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigits(Integer.parseInt(cardNumberArray[0]));
		creditCard.setSecondFourDigits(Integer.parseInt(cardNumberArray[1]));
		creditCard.setThirdFourDigits(Integer.parseInt(cardNumberArray[2]));
		creditCard.setFourthFourDigits(Integer.parseInt(cardNumberArray[3]));
		
		setValue(creditCard);
	}
	
	

}
