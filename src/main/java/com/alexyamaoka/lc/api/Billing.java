package com.alexyamaoka.lc.api;

public class Billing {
	private CreditCard creditCard;
	private PaymentAmount paymentAmount;
	
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	public PaymentAmount getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public void setPaymentAmount(PaymentAmount paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
}
