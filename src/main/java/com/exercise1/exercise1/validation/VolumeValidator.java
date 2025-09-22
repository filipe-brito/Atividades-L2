package com.exercise1.exercise1.validation;

import com.exercise1.exercise1.dto.DimensoesRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VolumeValidator implements ConstraintValidator<VolumeMax, DimensoesRequest> {
	private static final int MAX_VOLUME = 50 * 80 * 60; // 240.000 cm³

	@Override
	public boolean isValid(DimensoesRequest dim, ConstraintValidatorContext context) {
		if (dim == null)
			return true; // @NotNull trata a nulidade
		int volume = dim.getAltura() * dim.getLargura() * dim.getComprimento();
		return volume <= MAX_VOLUME;
	}
}
