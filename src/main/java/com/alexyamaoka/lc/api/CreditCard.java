package com.alexyamaoka.lc.api;

public class CreditCard {
	
	private Integer firstFourDigits;
	private Integer secondFourDigits;
	private Integer thirdFourDigits;
	private Integer fourthFourDigits;
	

	public Integer getFirstFourDigits() {
		return firstFourDigits;
	}

	public Integer getSecondFourDigits() {
		return secondFourDigits;
	}

	public Integer getThirdFourDigits() {
		return thirdFourDigits;
	}

	public Integer getFourthFourDigits() {
		return fourthFourDigits;
	}

	public void setFirstFourDigits(Integer firstFourDigits) {
		this.firstFourDigits = firstFourDigits;
	}

	public void setSecondFourDigits(Integer secondFourDigits) {
		this.secondFourDigits = secondFourDigits;
	}

	public void setThirdFourDigits(Integer thirdFourDigits) {
		this.thirdFourDigits = thirdFourDigits;
	}

	public void setFourthFourDigits(Integer fourthFourDigits) {
		this.fourthFourDigits = fourthFourDigits;
	}

	@Override
	public String toString() {
		return firstFourDigits + "-" + secondFourDigits + "-" + thirdFourDigits + "-" + fourthFourDigits;
	}
}
