package org.example.common.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.common.annotation.ValidEnum;

public class EnumValidator implements ConstraintValidator<ValidEnum, Enum> {
    private ValidEnum annotation;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        boolean result = false;
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        if (enumValues != null) {
            for (Object enumValue: enumValues) {
                if (enumValue.equals(value.name())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
