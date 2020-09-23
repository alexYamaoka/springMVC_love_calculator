package com.alexyamaoka.lc.converters;

import org.springframework.core.convert.converter.Converter;

import com.alexyamaoka.lc.api.CreditCard;

public class CreditCardConverterObjectToString implements Converter<CreditCard, String>{

	@Override
	public String convert(CreditCard source) {
		
		return source.toString();
	}

}
