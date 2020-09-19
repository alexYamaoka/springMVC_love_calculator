package com.alexyamaoka.lc.api;

import java.math.BigDecimal;

public class PaymentAmount {
	private BigDecimal billAmount;
	private String localeDefinition;
	
	
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	
	public String getLocaleDefinition() {
		return localeDefinition;
	}
	
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}
	
	public void setLocaleDefinition(String localeDefinition) {
		this.localeDefinition = localeDefinition;
	}

	@Override
	public String toString() {
		return billAmount + " " + localeDefinition;
	}
	
	
}
