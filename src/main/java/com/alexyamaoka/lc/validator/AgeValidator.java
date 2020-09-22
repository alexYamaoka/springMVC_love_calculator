package com.alexyamaoka.lc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// dont need annotation like component because of ConstraintValidator interface
public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;

	@Override
	public void initialize(Age age) {

		// for post construct work
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {

		// need to write validation logic here

		if (age == null) {
			return false;
		}

		if (age < this.lower || age > this.upper) {
			return false;
		}

		return true;
	}

}
