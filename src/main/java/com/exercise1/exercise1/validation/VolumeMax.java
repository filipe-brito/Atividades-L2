package com.exercise1.exercise1.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = VolumeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface VolumeMax {
	String message() default "O produto excede o volume máximo da caixa (240.000 cm³)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
