package com.alexyamaoka.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alexyamaoka.lc.api.CommunicationDTO;
import com.alexyamaoka.lc.api.UserRegistrationDTO;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// UserRegistrationDTO.CommunicationDTO.email
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CommunicationDTO.email", "email.empty");
		
		// check if the email is ending with gmail.com
		String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
		
		if (! email.endsWith("gmail.com")) {
			errors.rejectValue("communicationDTO.email", "email.invalidDomain");
		}
	}

}
