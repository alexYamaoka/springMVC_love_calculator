package com.alexyamaoka.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alexyamaoka.lc.api.UserRegistrationDTO;

public class UsernameValidator implements Validator {

	// checks if the UsernameValidator can be applied over a given DTO
	@Override
	public boolean supports(Class<?> clazz) {
		
		// only when we get a UserRegistrationDTO through the support method, our validate method will be applied
		
		return UserRegistrationDTO.class.equals(clazz);
	}
	

	// we need to write our custom validation logic
	@Override
	public void validate(Object target, Errors errors) {
		
		// to check if the field is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Username cannot be empty");
	}

}
