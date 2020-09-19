package com.alexyamaoka.lc.api;

public class CreditCard {
	private int firstFourDigits;
	private int secondFourDigits;
	private int thirdFourDigits;
	private int fourthFourDigits;
	
	
	public int getFirstFourDigits() {
		return firstFourDigits;
	}
	
	public int getSecondFourDigits() {
		return secondFourDigits;
	}
	
	public int getThirdFourDigits() {
		return thirdFourDigits;
	}
	
	public int getFourthFourDigits() {
		return fourthFourDigits;
	}
	
	public void setFirstFourDigits(int firstFourDigits) {
		this.firstFourDigits = firstFourDigits;
	}
	
	public void setSecondFourDigits(int secondFourDigits) {
		this.secondFourDigits = secondFourDigits;
	}
	
	public void setThirdFourDigits(int thirdFourDigits) {
		this.thirdFourDigits = thirdFourDigits;
	}
	
	public void setFourthFourDigits(int fourthFourDigits) {
		this.fourthFourDigits = fourthFourDigits;
	}

	@Override
	public String toString() {
		return firstFourDigits + " " + secondFourDigits + " " + thirdFourDigits + " " + fourthFourDigits;
	}
	
	
	
}
