package com.alexyamaoka.lc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AgeValidator {
	
	String message() default "Age should be between 18 and 60";
	int lower() default 18;
	int upper() default 60;
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	

}
